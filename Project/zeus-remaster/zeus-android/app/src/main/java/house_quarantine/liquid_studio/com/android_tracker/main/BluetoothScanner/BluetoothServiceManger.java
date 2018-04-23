package house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService.FirebaseObject;
import house_quarantine.liquid_studio.com.android_tracker.main.HomeViewModel;
/**
 * Created by joshua.a.t.tabilog on 1/16/18.
 */

public class BluetoothServiceManger{

    private BluetoothManager bluetoothManager;
    private FirebaseDatabase firebaseDatabase;
    private WifiManager wifiManager;
    private BatteryManager batteryManager;
    private DatabaseReference device_ref;
    private DatabaseReference main_ref;
    private FirebaseObject firebaseObject;
    private Context base_context;
    private HomeViewModel base_model;
    private DatabaseReference compliant;
    private String unique_id;
    private SharedPreferences prefs;
    private float batteryPct;
    private String dateScan;
    private IntentFilter intentFilter;
    private int linkSpeed;
    ScheduledExecutorService scheduler;
    public static final String BROADCAST_EVENT_BLE_SCAN_UPDATE = "scan_updated";
    public static final String BROADCAST_BUNDLE_KEY = "bundle_key";

    private static int TYPE_WIFI = 1;
    private static int TYPE_MOBILE = 2;
    private static int TYPE_NOT_CONNECTED = 0;
    private NetworkInfo networkInfo;
    private BluetoothLeScanner scanner = null;
 /*
        Bluetooth POJO in which the scanning and monitoring of device status is done
  */

    public BluetoothServiceManger(Context appcontext,HomeViewModel model,String id){

        //gets context of calling app
        unique_id = id;
        base_model = model;
        base_context = appcontext;


        //firebase pathsinstantiation
        firebaseDatabase = FirebaseDatabase.getInstance();
        device_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id + "/device_status");
        main_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id + "/ble_devices");
        compliant = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id + "/compliant");


        bluetoothManager = (BluetoothManager) base_context.getSystemService(Context.BLUETOOTH_SERVICE);
        batteryManager = (BatteryManager) base_context.getSystemService(Context.BATTERY_SERVICE);
        wifiManager = (WifiManager) base_context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        intentFilter = new IntentFilter();
        scheduler = Executors.newSingleThreadScheduledExecutor();
        prefs = base_context.getApplicationContext().getSharedPreferences(unique_id, Context.MODE_PRIVATE);


        //gets status of battery
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        firebaseObject = new FirebaseObject();



        //gets data every time power is connected/disconected/changed
        appcontext.registerReceiver(batteryInfoReceiver, intentFilter);


        //scheduler to update date every 5 seconds
        scheduler.scheduleAtFixedRate
                (new Runnable() {
                    public void run() {

                        base_model.setConnected(isNetworkConnected(base_context));
                        base_model.setBatteryLevel(batteryPct);
                        firebaseObject.setBattery_level(batteryPct);
                        firebaseObject.setDate(new Date().getTime()+"");
                        firebaseObject.setConnection_status(true);
                        device_ref.setValue(firebaseObject);
                        String[] BleDevices = prefs.getString("macaddr", "").split(",");
                        Log.d("MSG BLE DEVICES", BleDevices.length +"");

                        for (int i = 0; i < BleDevices.length; i++) {

                            //update current data for each device scanned
                            Log.d("MSG", BleDevices[i]);
                            double distance = Double.parseDouble((prefs.getString(BleDevices[i] + "distance", "200")));
                            Log.d("MSG distance", distance+"");
                            String threshold = prefs.getString("threshold","1");
                            falsifyDistance(distance, BleDevices[i],Integer.parseInt(threshold),prefs.getString(BleDevices[i].concat("-Timestamp"),""));
                            main_ref.child(BleDevices[i]).child("timestamp").setValue(prefs.getString(BleDevices[i].concat("-Timestamp"),""));
                        }
                    }
                }, 3, 5, TimeUnit.SECONDS);
    }

    public void getBeacon(){

        //gets current date
        Long newDate = new Date().getTime();
        dateScan =  newDate.toString();
        scanner = bluetoothManager.getAdapter().getBluetoothLeScanner();
        final String[] macaddr = prefs.getString("macaddr","").split(",");

        if (scanner != null) {
            scanner.stopScan(mScanCallBack);
            ScanSettings settings = new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build();
            List<ScanFilter> filters = new ArrayList<>();
            if (macaddr.length > 0){
                for (int i = 0;i < macaddr.length; i++) {

                    Log.d("getBeacon", "macaddr" + macaddr[i]);
                    filters.add(new ScanFilter.Builder().setDeviceAddress(macaddr[i]).build());
                }

                //starts scanning
                scanner.startScan(filters, settings, mScanCallBack);
            }
            else {
                Toast.makeText(base_context,"NO BEACONS",Toast.LENGTH_LONG).show();
            }
        }
    }



    private ScanCallback mScanCallBack = new ScanCallback() {

        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            onLeScan(result.getDevice(),result.getRssi(),result);
        }
    };



    //Callback for found data on bluetooh scan

    public void onLeScan(BluetoothDevice device, int rssi, ScanResult result) {


        //instantiate sharedPreferences
        prefs = base_context.getSharedPreferences(unique_id,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        //parses data to ibeacon format
        IBeaconScanData iBeacon = new IBeaconScanData(result);
        String uuid = iBeacon.getUuid();
        float power = iBeacon.getTxPower();

        //calculates distance according to power and rssi
        double distance = calculateAccuracy(power,rssi);


        //saves UUID/Distance/Timestamp to shared preferences for external access
        editor.putString(device.getAddress()+"UUID",""+ uuid);
        String strdistance = limit(distance);
        editor.putString(device.getAddress()+"distance",strdistance);
        editor.putString(device.getAddress()+"name",device.getName()+"");
        Long beaconDate = new Date().getTime();
        editor.putString(device.getAddress()+"-Timestamp",beaconDate.toString());

        //sets address, name, and distance of beacon scanned to iBeacon Object
        iBeacon.setAddress(device.getAddress());
        iBeacon.setName(prefs.getString(device.getAddress()+"type",""));
        iBeacon.setAccuracy(((float) distance));


        //gets threshold
        String threshold = prefs.getString("threshold","")+".0";
        double temp = Double.parseDouble(threshold);
        temp = (distance/temp)*100;


        //saves the ibeacon instance to shared preferences
        iBeacon.setThreshold(((int) temp));
        editor.putString(device.getAddress(), iBeacon.toString());
        editor.apply();
        editor.commit();


        //broadcasts to UI that updated beacon packet is found
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(base_context);
        Intent localIntent = new Intent(BROADCAST_EVENT_BLE_SCAN_UPDATE);
        localIntent.putExtra(BROADCAST_BUNDLE_KEY, iBeacon.getAddress());
        localBroadcastManager.sendBroadcast(localIntent);

    }


    //This is where the calculation of distance, relative to RSSI and Power, happens
    protected double calculateAccuracy(float txPower, double rssi) {
        float accuracy;
        if (rssi == 0) {
            return -1;
        }
        double ratio = rssi * 1.0 / txPower;
        if (ratio < 1.0) {
            accuracy = (float) Math.pow(ratio, 10);
        } else {
            accuracy = (float) ((0.89976) * Math.pow(ratio, 7.7095) + 0.111);
        }
        return ((double) accuracy);
    }


    // marks user as non-compliant
    // if scanned beacon is too far or beacon has not been broadcasting for longer than 20 seconds
    private void falsifyDistance(Double distance, String mac_addr, int threshold,String timestamp) {
        Long dif = new Date().getTime() -  Long.parseLong(timestamp);

        if (distance > threshold ||  dif > 20000) {

            main_ref.child(mac_addr).child("proximity").setValue(false);
        } else {

            main_ref.child(mac_addr).child("proximity").setValue(true);
        }
    }

    public String limit(double num){
        return String.format("%.2f", num);
    }




    //battery status broadcaster
    public BroadcastReceiver batteryInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            batteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

            if (level != -1 && scale != -1) {
                batteryPct = (int) ((level / (float) scale) * 100f);
            }


        }
    };

    public int getConnectivityStatus(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI
                    && networkInfo.getState() == NetworkInfo.State.CONNECTED) {

                return TYPE_WIFI;

            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE
                    && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return TYPE_MOBILE;
            }
        }
        return TYPE_NOT_CONNECTED;
    }

    public boolean isNetworkConnected(Context context) {

        int networkStatus = getConnectivityStatus(context);
        if (networkStatus == TYPE_WIFI || networkStatus == TYPE_MOBILE) {
            return true;
        } else {
            return false;
        }

    }

    //kills existing executor onActivityTerminate
    public void kill() {
        ScheduledExecutorService  executor = scheduler;
        BluetoothLeScanner scanner = bluetoothManager.getAdapter().getBluetoothLeScanner();


        if (scanner != null) {
            scanner.stopScan(mScanCallBack);
        }
        if (executor != null){
            executor.shutdown();
        }
    }


}

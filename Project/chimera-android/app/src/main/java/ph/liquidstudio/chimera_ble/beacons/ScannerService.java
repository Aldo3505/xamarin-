package ph.liquidstudio.chimera_ble.beacons;

import android.app.Notification;
import android.app.PendingIntent;
import android.arch.lifecycle.LifecycleService;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ph.liquidstudio.chimera_ble.MainActivity;
import ph.liquidstudio.chimera_ble.common.Resource;
import ph.liquidstudio.chimera_ble.proximity.Device;

public class ScannerService extends LifecycleService {

    private static final String TAG = ScannerService.class.getSimpleName();
    private static final int BLE_SCANNER_SERVICE_ID = 1001;
    private BluetoothLeScanner bleScanner;
    private ScanSettings scanSettings;
    private ZoneBuilder zoneBuilder;
    private Map<String, BeaconScanData> scanResultsMap;
    private Map<String, BeaconModel> parsedBeaconsMap;
    private MutableLiveData<Resource<Map<String, BeaconScanData>>> scanResultsLiveData;
    private MutableLiveData<Resource<Map<String,BeaconModel>>> parsedBeaconsLiveData;
    private List<BeaconModel> nearestBeaconsList;

    //Service binder
    public class LocalBinder extends Binder {
        public ScannerService getService(){
            return ScannerService.this;
        }
    }

    private IBinder localBinder = new LocalBinder();

    private ScanCallback scanCallback = new ScanCallback() {
       @Override
       public void onBatchScanResults(List<ScanResult> results) {
           super.onBatchScanResults(results);


           for(ScanResult result : results){
               BeaconScanData scanData = scanResultsMap.get(result.getDevice().getAddress());
               if(scanData != null){

                   scanData.update(result);
                   scanResultsMap.put(scanData.getAddress(), scanData);

                   //creates new beacon object
                   BeaconModel beaconModel = new BeaconModel();
                   beaconModel.setAddress(scanData.getAddress());
                   beaconModel.setAccuracy(scanData.getAccuracy());
                   beaconModel.setLocation(zoneBuilder.getDevices().getValue().getData().get(scanData.getAddress()).getLocation());

                   //puts scanned beacons in a hashmap
                   parsedBeaconsMap.put(scanData.getAddress(),beaconModel);



               }else{
                scanResultsMap.put(result.getDevice().getAddress(), new IBeaconScanData(result));
               }
           }
           scanResultsLiveData.postValue(Resource.success(scanResultsMap));

           //posts parsedBeaconsMap to parsedBeacons livedata
           //observed on start()

           parsedBeaconsLiveData.setValue(Resource.success(parsedBeaconsMap));

       }

       @Override
       public void onScanFailed(int errorCode) {
           super.onScanFailed(errorCode);
           Resource<Map<String , BeaconScanData>> scanResource = Resource.failed("BLE error code: " + errorCode , scanResultsMap);
           scanResultsLiveData.postValue(scanResource);
       }
   };

    private Observer<Resource<Map<String, Device>>> deviceObserver = new Observer<Resource<Map<String, Device>>>() {
        @Override
        public void onChanged(@Nullable Resource<Map<String, Device>> mapResource) {

            if (mapResource != null) {
                Log.d(TAG, "(onChanged)  device init: " + mapResource.getStatus());
                if (mapResource.getStatus() == Resource.Status.SUCCESS) {
                    bleScanner.stopScan(scanCallback);
                    Map<String, Device> deviceMap = mapResource.getData();
                    Log.d(TAG, "(onChanged)  creating scan filters for  " + deviceMap.size() + " devices");
                    List<ScanFilter> filters = new ArrayList<>();
                    for(String deviceId : deviceMap.keySet()){
                        Device device = deviceMap.get(deviceId);
                        if(deviceId.contains(":")){
                            filters.add(new ScanFilter.Builder().setDeviceAddress(deviceId).build());
                            scanResultsMap.put(device.getId(), new IBeaconScanData(device));
                        }
                    }
                    bleScanner.startScan(filters, scanSettings, scanCallback);

                }
            }else{
                Log.d(TAG, "(onChanged) empty resource observed");
            }
        }
    };



    private Observer<Resource<Map<String, BeaconModel>>> sortingObserver = new Observer<Resource<Map<String, BeaconModel>>>() {
        @Override
        public void onChanged(@Nullable Resource<Map<String, BeaconModel>> mapResource) {


            //on change, saves the data to a new list
            nearestBeaconsList = new ArrayList<>();
            for ( String key : mapResource.getData().keySet() ) {
                if (key != null){
                    //adds all detected beacons to array
                    nearestBeaconsList.add(mapResource.getData().get(key));
                }
            }
            //sorts according to accuracy (distance)
            nearestBeaconsList.sort(comparator);

            //trilaterates
            trilaterate(nearestBeaconsList);

        }
    };


    //comparator to sort via accuracy/distance
    private Comparator<BeaconModel> comparator = new Comparator<BeaconModel>() {
        @Override
        public int compare(BeaconModel o1, BeaconModel o2) {
            return (Float.compare(o1.getAccuracy(), o2.getAccuracy()));
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        //Setup bluetooth
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        if (bluetoothManager != null) {
            BluetoothAdapter adapter = bluetoothManager.getAdapter();
            bleScanner = adapter.getBluetoothLeScanner();
            scanSettings = new ScanSettings.Builder()
                    .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                    .setReportDelay(250)   //TODO should probably check first if the device supports batching
                    .build();
        }


        //initalizes maps and livedata
        zoneBuilder = new ZoneBuilder(this);
        parsedBeaconsMap = new HashMap<>();
        scanResultsMap = new HashMap<>();
        scanResultsLiveData = new MutableLiveData<>();
        parsedBeaconsLiveData = new MutableLiveData<>();
    }

    @Override
    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        Log.d(TAG, "(onBind) client bound, starting service in background mode");
        stopForeground(true);
        return localBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "(onStartCommand)");
        return START_NOT_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "(onUnbind) clients unbound, setting service in foreground mode");
        startForeground(BLE_SCANNER_SERVICE_ID, getServiceNotification());
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "(onRebind) client re-binding, setting service to background");
        stopForeground(true);
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.d(TAG, "(onTaskRemoved)");
        super.onTaskRemoved(rootIntent);
        bleScanner.stopScan(scanCallback);
        stopSelf();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "(onDestroy)");
        super.onDestroy();
        bleScanner.stopScan(scanCallback);
        stopSelf();
    }

    private Notification getServiceNotification(){

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, BLE_SCANNER_SERVICE_ID, notificationIntent, 0);

        NotificationCompat.Builder notifBuilder = new NotificationCompat.Builder(this, TAG)
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .setContentTitle("CHANGE")
                .setContentText("CHANGE");

        return notifBuilder.build();
    }

    public MutableLiveData<Resource<Map<String, BeaconScanData>>> start(){

        //load devices
        zoneBuilder.load().observe(this, deviceObserver);


        /**
         * - load parsed beacon models with location
         * - created a new model to avoid changing the standard Beacon and IBeacon Classes
         */
        loadParsedBeaconsLiveData().observe(this,sortingObserver);
        return scanResultsLiveData;
    }



    public void stop() {
        if(bleScanner != null){
            bleScanner.stopScan(scanCallback);
        }
    }


    public MutableLiveData<Resource<Map<String, BeaconModel>>> loadParsedBeaconsLiveData() {
        return parsedBeaconsLiveData;
    }


    public MutableLiveData<Resource<Map<String, BeaconScanData>>> getScanResultsLiveData() {
        return scanResultsLiveData;
    }

    //math helper function
    private void trilaterate(List<BeaconModel> beacons){

        if (beacons.size()>=3){

            float a1 = beacons.get(0).getLocation().getX();
            float b1 = beacons.get(0).getLocation().getY();
            float a2 = beacons.get(1).getLocation().getX();
            float b2 = beacons.get(1).getLocation().getY();
            float a3 = beacons.get(2).getLocation().getX();
            float b3 = beacons.get(2).getLocation().getY();
            float r1 = beacons.get(0).getAccuracy();
            float r2 = beacons.get(1).getAccuracy();
            float r3 = beacons.get(2).getAccuracy();


            float a1sq = a1 * a1;
            float b1sq = b1 * b1;
            float a2sq = a2 * a2;
            float b2sq = b2 * b2;
            float a3sq = a3 * a3;
            float b3sq = b3 * b3;
            float r1sq = r1 * r1;
            float r2sq = r2 * r2;
            float r3sq = r3 * r3;

            float num1 = (a2 - a1) * (a3sq + b3sq - r3sq) + (a1 - a3) * (a2sq + b2sq - r2sq) + (a3 - a2) * (a1sq + b1sq - r1sq);
            float den1 = 2 * (b3 * (a2 - a1) + b2 * (a1 - a3) + b1 * (a3 - a2));
            float y = num1 / den1;
            float num2 = r2sq - r1sq + a1sq - a2sq + b1sq - b2sq -2 * (b1 - b2) * y;
            float den2 = 2 * (a1 - a2);
            float x = num2 / den2;


            Log.d(TAG, "trilaterate: x=" + x + ", y=" + y);

            Log.d(TAG,
                    "\n " + beacons.get(0).getAccuracy() + " - " + beacons.get(0).getAddress() +
                    "\n " + beacons.get(1).getAccuracy() + " - " + beacons.get(1).getAddress() +
                    "\n " + beacons.get(2).getAccuracy() + " - " + beacons.get(2).getAddress() +
                    "\n ");
        }

    }

}

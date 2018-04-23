package house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner;

import android.bluetooth.le.ScanResult;

import com.google.gson.Gson;

/**
 * Created by eugene.p.lozada on 1/18/18.
 */

public abstract class BeaconScanData {

    private static final String TAG = BeaconScanData.class.getSimpleName();
    protected int threshold;
    protected String name;
    protected String address;
    protected String uuid;
    protected int major;
    protected int minor;
    protected float rssi;

    public boolean isPolling() {
        return polling;
    }

    public void setPolling(boolean polling) {
        this.polling = polling;
    }

    protected boolean polling;


    public int getThreshold() {
        return threshold;
    }

    protected float txPower;
    protected long timeStamp;
    protected float accuracy;

    public void setName(String name) {
        String temp1 = name.substring(0,1).toUpperCase();
        String temp2 = name.substring(1,name.length());
        this.name = temp1 + temp2;


    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getUuid() {
        return uuid;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public float getRssi() {
        return rssi;
    }

    public float getTxPower() {
        return txPower;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public BeaconScanData(String address){
        this.address = address;
    }

    public BeaconScanData(ScanResult result){
        update(result);
    }

    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public void copy(BeaconScanData scanData){
        this.name = scanData.name;
        this.address = scanData.address;
        this.uuid = scanData.uuid;
        this.major = scanData.major;
        this.minor = scanData.minor;
        this.rssi = scanData.rssi;
        this.txPower = scanData.txPower;
        this.timeStamp = scanData.timeStamp;
        this.threshold = scanData.threshold;
        this.accuracy = scanData.accuracy;
    }
    //Implement for different variations of beacon protocols
    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
    public float getAccuracy(){
        return accuracy;
    }

    //Implement for different variations of beacon protocols
    public abstract void update(ScanResult result);


}

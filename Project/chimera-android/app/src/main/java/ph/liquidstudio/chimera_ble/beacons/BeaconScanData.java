package ph.liquidstudio.chimera_ble.beacons;

import android.bluetooth.le.ScanResult;

import com.google.gson.Gson;

/**
 * Created by eugene.p.lozada on 1/18/18.
 */

public abstract class BeaconScanData {

    private static final String TAG = BeaconScanData.class.getSimpleName();
    protected String name;
    protected String address;
    protected String uuid;
    protected int major;
    protected int minor;
    protected float rssi;
    protected float txPower;
    protected long timeStamp;
    private transient Gson gson = new Gson();


    public BeaconScanData(String address, String name) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public String getAddress() {
        return address == null ? "" : address;
    }

    public String getUuid() {
        return uuid == null ? "" : uuid;
    }

    public int getMajor() {
        return major == 0 ? -1 : major;
    }

    public int getMinor() {
        return minor == 0 ? -1 : minor;
    }

    public float getRssi() {
        return rssi == 0 ? -100 : rssi;
    }

    public float getTxPower() {
        return txPower == 0 ? -100 : txPower;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public BeaconScanData(String address) {
        this.address = address;
    }

    public BeaconScanData(ScanResult result) {
        update(result);
    }

    public void copy(BeaconScanData scanData) {
        this.name = scanData.name;
        this.address = scanData.address;
        this.uuid = scanData.uuid;
        this.major = scanData.major;
        this.minor = scanData.minor;
        this.rssi = scanData.rssi;
        this.txPower = scanData.txPower;
        this.timeStamp = scanData.timeStamp;
    }

    public String toString() {
        return gson.toJson(this);
    }

    //Implement for different variations of beacon protocols
    public abstract float getAccuracy();

    //Implement for different variations of beacon protocols
    public abstract void update(ScanResult result);

}

package ph.liquidstudio.chimera_ble.beacons;

import android.bluetooth.le.ScanResult;
import android.util.Log;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.UUID;

import ph.liquidstudio.chimera_ble.proximity.Device;

/**
 * Created by eugene.p.lozada on 1/22/18.
 */

public class IBeaconScanData extends BeaconScanData {

    private static final String TAG = IBeaconScanData.class.getSimpleName();

    public IBeaconScanData(ScanResult result){
        super(result);
    }

    public IBeaconScanData(Device device) {
        super(device.getId());
    }
    @Override
    public void update(ScanResult result) {
        if (result == null || result.getScanRecord() == null) {
            throw new IllegalArgumentException("null or invalid ScanResult");
        }
        byte[] scanData = result.getScanRecord().getBytes();
        if (scanData[7] == 0x02 && scanData[8] == 0x15) {
            //Identifiers
            ByteBuffer buffer = ByteBuffer.wrap(Arrays.copyOfRange(scanData, 9, 25));
            address = result.getDevice().getAddress();
            uuid = new UUID(buffer.getLong(), buffer.getLong()).toString();
            major = (scanData[25] & 0xff) * 0x100 + (scanData[26] & 0xff);
            minor = (scanData[27] & 0xff) * 0x100 + (scanData[28] & 0xff);
            rssi = result.getRssi();
            txPower =(int) scanData[29];
            timeStamp = System.currentTimeMillis();
        } else{
            Log.d(TAG, "parse() not an iBeaacon");
        }
    }

    @Override
    public  float getAccuracy(){
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
        return accuracy;
    }
}

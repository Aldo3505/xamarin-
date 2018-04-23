package house_quarantine.liquid_studio.com.android_tracker.main;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import java.text.DateFormat;
import java.util.Date;

import house_quarantine.liquid_studio.com.android_tracker.BR;
import house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData;

/**
 * Created by joshua.a.t.tabilog on 1/15/18.
 */

public class HomeViewModel extends BaseObservable {

    @Bindable
    BeaconScanData packet;

    @Bindable
    private Boolean delinquent;

    public Boolean getDelinquent() {
        return delinquent;
    }

    public void setDelinquent(Boolean delinquent) {
        notifyPropertyChanged(BR.delinquent);
        this.delinquent = delinquent;
    }

    @Bindable
    private String lastUpdate;

    @Bindable
    private float batteryLevel;

    private int wifiRssi;

    @Bindable
    private String wifiLevel;

    public float getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(float batteryLevel) {
        this.batteryLevel = batteryLevel;
        notifyPropertyChanged(BR.batteryLevel);
    }
    @Bindable
    private boolean connected;

    public boolean isConnected() {
        return connected;

    }

    public void setConnected(boolean connected) {
        notifyPropertyChanged(BR.connected);
        this.connected = connected;
    }

    private static DateFormat format = format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM);


    public BeaconScanData getPacket() {
        return packet;

    }

    public void setPacket(BeaconScanData packet) {
        this.packet = packet;
        notifyPropertyChanged(BR.packet);
    }


    public static String formatTimeStamp(long millis) {
        return format.format(new Date(millis));
    }

}


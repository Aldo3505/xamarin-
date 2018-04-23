package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
/**
 * Created by eugene.p.lozada on 1/26/18.
 */

public class QRViewModel extends BaseObservable {

    @Bindable
    private String barCodeValue;
    @Bindable
    private String deviceName;
    @Bindable
    private String deviceAddress;
    @Bindable
    private boolean scanning =false;
    @Bindable
    private boolean hasInfo=false;

    public String getBarCodeValue() {
        return barCodeValue;
    }

    public void setBarCodeValue(String barCodeValue) {
        this.barCodeValue = barCodeValue;
        notifyPropertyChanged(BR.barCodeValue);
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
        notifyPropertyChanged(BR.deviceName);
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
        notifyPropertyChanged(BR.deviceAddress);
    }

    public boolean isScanning() {
        return scanning;
    }

    public void setScanning(boolean scanning) {
        this.scanning = scanning;
        notifyPropertyChanged(BR.scanning);
    }


    public void setHasInfo(boolean hasInfo) {
        this.hasInfo = hasInfo;
        notifyPropertyChanged(BR.hasInfo);
    }

    public boolean isHasInfo() {
        return hasInfo;
    }
}

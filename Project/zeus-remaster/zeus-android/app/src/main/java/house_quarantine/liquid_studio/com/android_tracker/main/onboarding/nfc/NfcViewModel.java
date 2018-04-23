package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by joshua.a.t.tabilog on 2/6/18.
 */

public class NfcViewModel extends BaseObservable {
    @Bindable
    private String mac_address;

    @Bindable
    private int verified;


    public String getMac_address() {
        return mac_address;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;

    }
}

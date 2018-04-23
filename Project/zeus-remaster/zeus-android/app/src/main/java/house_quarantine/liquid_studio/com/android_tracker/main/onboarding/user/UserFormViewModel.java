package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;


/**
 * Created by eugene.p.lozada on 1/26/18.
 */

public class UserFormViewModel extends BaseObservable {

    @Bindable
    private String name;
    @Bindable
    private String nric;
    @Bindable
    private String address;
    @Bindable
    private String phone;
    @Bindable
    private boolean enabled=true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        notifyPropertyChanged(BR.name);
        this.name = name;
    }

    public String getNric() {
        return nric;
    }

    public void setNric(String nric) {
        notifyPropertyChanged(BR.nric);
        this.nric = nric;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        notifyPropertyChanged(BR.phone);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        notifyPropertyChanged(BR.enabled);
    }
}

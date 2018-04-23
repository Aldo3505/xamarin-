
package android.databinding;
import house_quarantine.liquid_studio.com.android_tracker.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 21;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.main_activity:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.MainActivityBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_user_form:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentUserFormBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.nfc_fragment:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.NfcFragmentBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.beacon_ad_packet:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.BeaconAdPacketBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.facial_registration:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.FacialRegistrationBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr_wearable:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentQrWearableBinding.bind(view, bindingComponent);
                case house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr:
                    return house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentQrBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -1330819999: {
                if(tag.equals("layout/main_activity_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.main_activity;
                }
                break;
            }
            case -113435457: {
                if(tag.equals("layout/fragment_user_form_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_user_form;
                }
                break;
            }
            case 690793114: {
                if(tag.equals("layout/nfc_fragment_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.nfc_fragment;
                }
                break;
            }
            case -1161127329: {
                if(tag.equals("layout/beacon_ad_packet_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.beacon_ad_packet;
                }
                break;
            }
            case -523596968: {
                if(tag.equals("layout/facial_registration_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.facial_registration;
                }
                break;
            }
            case 403632254: {
                if(tag.equals("layout/fragment_qr_wearable_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr_wearable;
                }
                break;
            }
            case -1676866564: {
                if(tag.equals("layout/fragment_qr_0")) {
                    return house_quarantine.liquid_studio.com.android_tracker.R.layout.fragment_qr;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"address"
            ,"barCodeValue"
            ,"batteryLevel"
            ,"connected"
            ,"delinquent"
            ,"deviceAddress"
            ,"deviceName"
            ,"enabled"
            ,"face_id"
            ,"handler"
            ,"hasInfo"
            ,"lastUpdate"
            ,"mac_address"
            ,"model"
            ,"name"
            ,"nric"
            ,"packet"
            ,"phone"
            ,"scanning"
            ,"verified"
            ,"wifiLevel"};
    }
}
package house_quarantine.liquid_studio.com.android_tracker.main.onboarding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRFragment;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user.UserFormFragment;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID.FaceFragment;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcFragment;

/**
 * Created by eugene.p.lozada on 1/25/18.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<>();
    QRFragment qrFragment;
    public PagerAdapter(FragmentManager fm) {
        super(fm);
        qrFragment = new QRFragment();
        fragments.add(qrFragment.newInstance(R.layout.fragment_qr));
        fragments.add(new NfcFragment());
        fragments.add(new UserFormFragment());
        fragments.add(new FaceFragment());
        fragments.add(qrFragment.newInstance(R.layout.fragment_qr_wearable));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public Fragment getRegisteredFragment(int position) {
        return this.getItem(position);
    }
}

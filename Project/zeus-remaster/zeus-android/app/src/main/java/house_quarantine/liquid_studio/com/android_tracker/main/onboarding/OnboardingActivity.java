package house_quarantine.liquid_studio.com.android_tracker.main.onboarding;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.lang.ref.PhantomReference;

import house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService.FirebaseListener;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc.NfcFragment;

import house_quarantine.liquid_studio.com.android_tracker.R;

public class OnboardingActivity extends FragmentActivity {

    private String unique_id = "S67128561X";
    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private ViewPager pager;
    private IntentFilter writeTagFilters[];
    private boolean writeMode;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        new FirebaseListener(this,unique_id).getUserKeys();
        pager = findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        //NFC Detection
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        tagDetected.addCategory(Intent.CATEGORY_DEFAULT);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

    }


    @Override
    public void onBackPressed() {

        finish();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, writeTagFilters, null);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (pager.getCurrentItem()==1){
            setIntent(intent);
            NfcFragment nfcFragment = new NfcFragment();
            nfcFragment.intentFound(intent,this);
        }
    }

}

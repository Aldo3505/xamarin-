package house_quarantine.liquid_studio.com.android_tracker.main.splashActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.main.MainActivity;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.OnboardingActivity;

/**
 * Created by joshua.a.t.tabilog on 2/7/18.
 * Only a static page
 */

public class HomeActivity extends Activity {

    private static final int MY_REQUESTS_PERMISSION = 0;
    private Button onboard;
    private Button monitor;
    private Intent regIntent;
    private Intent beaconsIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        monitor = findViewById(R.id.monitor_button);
        onboard = findViewById(R.id.reg_button);
        checkPermissions(this);
        regIntent = new Intent(this, OnboardingActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        beaconsIntent = new Intent(this, MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);


        onboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(regIntent);
            }
        });

        monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(beaconsIntent);
            }
        });
    }

    public void checkPermissions(Activity thisActivity) {
        if (ContextCompat.checkSelfPermission(thisActivity,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            {
                ActivityCompat.requestPermissions(thisActivity,
                        new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CAMERA, Manifest.permission.NFC, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, MY_REQUESTS_PERMISSION);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_REQUESTS_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this," Permission Granted! Please Restart the app", Toast.LENGTH_LONG);

                } else {
                    closeContextMenu();
                }
                return;
            }

        }
    }
}

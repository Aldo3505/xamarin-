package house_quarantine.liquid_studio.com.android_tracker.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.Date;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.databinding.MainActivityBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData;
import house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BluetoothServiceManger;
import house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.IBeaconScanData;
import house_quarantine.liquid_studio.com.android_tracker.main.FacecheckActivity.CameraActivity;
import house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService.FirebaseListener;
import house_quarantine.liquid_studio.com.android_tracker.main.NfcActivity.NfcManager;

public class MainActivity extends AppCompatActivity implements MainHandler {


    private String unique_id = "S67128561X";
    private ProgressBar progressBar;
    private TextView connect_text;
    private RecyclerView recyclerView;
    private HomeViewModel model;
    private TextView mTextMessage;
    private BluetoothServiceManger bsm;
    private BeaconListAdapter adapter;
    private FloatingActionButton fab;
    public static final String BEACON_KEYS = "keys_updated";
    public static final String MAC_BROADCAST_KEY = "bundle_key";
    public static final int StartScan = 0;
    private static final int MY_REQUESTS_PERMISSION = 0;
    private FirebaseListener firebaseListener;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference main_ref;


    private BroadcastReceiver KeyScanner = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //   Log.d("BLE MSG", "(onReceive) BLE Scan event received:");
            progressBar = findViewById(R.id.waiting_bar);
            connect_text = findViewById(R.id.text_connect);
            progressBar.setVisibility(View.GONE);
            connect_text.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            SharedPreferences prefs = context.getSharedPreferences(unique_id, MODE_PRIVATE);
            String threshold = prefs.getString("threshold", "5");
            Log.d("BLE MSG", threshold);
            Log.d("Beacon Thread", new Date().toString() + " " + Thread.currentThread().getName());


            //starts beacon scanning
            bsm.getBeacon();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("On create", "Created Activity");
        setContentView(R.layout.main_activity);


        //Register Receiver for Firebase Data
        firebaseDatabase = FirebaseDatabase.getInstance();
        main_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id);
        LocalBroadcastManager.getInstance(this).registerReceiver(KeyScanner, new IntentFilter(FirebaseListener.BEACON_KEYS));

        //gets firebase config
       firebaseListener = new FirebaseListener(this,unique_id);
       firebaseListener.getUserKeys();


        //MainBeacon Scan handling
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        model = new HomeViewModel();
        binding.setHandler(this);
        binding.setModel(model);
        recyclerView = findViewById(R.id.list_beacons);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BeaconListAdapter();
        recyclerView.setAdapter(adapter);
        bsm = new BluetoothServiceManger(this, model, unique_id);


        //registers receiver for scanned bluetooth data
        LocalBroadcastManager.getInstance(this).registerReceiver(bleScanReceiver, new IntentFilter(BluetoothServiceManger.BROADCAST_EVENT_BLE_SCAN_UPDATE));
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.NFC}, MY_REQUESTS_PERMISSION);


        fab = findViewById(R.id.splash_button);


        //Firebase Delinquent Listener
        main_ref.child("delinquency").child("delinquent").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                model.setDelinquent(((Boolean) dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

    @Override
    public void onBackPressed() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(KeyScanner);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(bleScanReceiver);
        bsm.kill();
        this.finish();

    }


    public void onCameraClicked() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    @Override
    public void onNfcClicked() {

        Intent intent = new Intent(this, NfcManager.class);
        startActivity(intent);
    }

    private BroadcastReceiver bleScanReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //Receiver for onScan Bluetooth
            String mac = intent.getExtras().getString(BluetoothServiceManger.BROADCAST_BUNDLE_KEY);
            SharedPreferences prefs = getSharedPreferences(unique_id, MODE_PRIVATE);
            String data = prefs.getString(mac, "{}");
            Gson gson = new Gson();
            //set to adapter
            BeaconScanData beacon = gson.fromJson(data, IBeaconScanData.class);
            adapter.setBeacon(beacon);
        }
    };

}

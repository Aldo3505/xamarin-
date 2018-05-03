package ph.liquidstudio.chimera_ble;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ph.liquidstudio.chimera_ble.beacons.ScannerService;

public class MainActivity extends AppCompatActivity {


    private ScannerService proximityService;
    private Intent serviceIntent;
    private static final String TAG = "MainActivity";
    private boolean service = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //create intent for service Proximity tracking
        serviceIntent = new Intent(MainActivity.this, ScannerService.class);
        Log.d(TAG, "Class created");
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!service){
            bindService(serviceIntent,scannerServiceConnection, Context.BIND_AUTO_CREATE);
            startService(serviceIntent);
            service = true
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbindService(scannerServiceConnection);
        if (service){
            stopService(serviceIntent);
            service = false;
        }

    }

    private ServiceConnection scannerServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Toast.makeText(MainActivity.this,"Established connection to service",Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onServiceConnected: ESTABLISHED");
            proximityService = ((ScannerService.LocalBinder) service).getService();
            proximityService.start();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}

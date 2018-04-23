package house_quarantine.liquid_studio.com.android_tracker.main.NfcActivity;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.main.FacecheckActivity.CameraActivity;

/**
 * Created by joshua.a.t.tabilog on 1/15/18.
 */

public class NfcManager extends Activity{


    private NfcAdapter nfcAdapter;
    private PendingIntent pendingIntent;
    private IntentFilter writeTagFilters[];
    private boolean writeMode;
    private Context context;
    private TextView tvNFCContent;
    private String nfc_mac;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private String unique_id = "S67128561X";
    private DatabaseReference attempt_ref = database.getReference("/ZEUS/DEV/USERS/"+unique_id+"/attempts");
    private DatabaseReference compliant = database.getReference("/ZEUS/DEV/USERS/"+unique_id+"/compliant");
    private DatabaseReference main_ref = database.getReference("/ZEUS/DEV/USERS/"+unique_id+"/");
    private String[] user_nfc;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nfc);
        context = this;
        imageView = (ImageView)findViewById(R.id.nfcimage);
        Toast.makeText(NfcManager.this, "NFC Verficiation Loaded.", Toast.LENGTH_SHORT).show();
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(unique_id,Context.MODE_PRIVATE);
        nfc_mac = prefs.getString("nfc_keys","");
        Log.d("MSG",nfc_mac);
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if (nfcAdapter == null) {
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
        }
        pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        tagDetected.addCategory(Intent.CATEGORY_DEFAULT);
        writeTagFilters = new IntentFilter[] { tagDetected };
        toastNfcId(getIntent());
    }


    /******************************************************************************
     **********************************Read From NFC Tag***************************
     ******************************************************************************/

    private String ByteArrayToHexString(byte [] inarray) {
        int i, j, in;
        String [] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        String out= "";
        for(j = 0 ; j < inarray.length ; ++j)
        {
            in = (int) inarray[j] & 0xff;
            i = (in >> 4) & 0x0f;
            out += hex[i];
            i = in & 0x0f;
            out += hex[i]+":";
        }
        out = out.substring(0,out.length()-1);
        return out;
    }

    @Override
    protected void onNewIntent(Intent intent) {

        setIntent(intent);

        if (intent.hasExtra(NfcAdapter.EXTRA_TAG)){
//            Toast.makeText(this,"NEW INTENT",Toast.LENGTH_LONG).show();
            toastNfcId(intent);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        WriteModeOff();
    }

    @Override
    public void onResume(){
        super.onResume();
        WriteModeOn();
    }

    private void toastNfcId(Intent intent){
        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        if(tag == null){
            return;
        }
        String id = ByteArrayToHexString(tag.getId());
        if (nfc_mac.contains(id)){


            compliant.child("nfc").setValue(true);
            attempt_ref.child("nfc").setValue(true);
//
//
//            Button button = findViewById(R.id.next_done);
//            button.setVisibility(View.VISIBLE);
//            button.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
            imageView.setAlpha(1f);

            Toast.makeText(this, getString(R.string.toast_nfc_verification_success,id),Toast.LENGTH_LONG).show();
        } else{
            compliant.child("nfc").setValue(false);
            attempt_ref.child("nfc").setValue(false);
            Toast.makeText(this,"NFC Tag is not recognized" ,Toast.LENGTH_LONG).show();
        }
    }
    /******************************************************************************
     **********************************Enable Write********************************
     ******************************************************************************/
    private void WriteModeOn(){
        writeMode = true;
        nfcAdapter.enableForegroundDispatch(this, pendingIntent, writeTagFilters, null);
    }
    /******************************************************************************
     **********************************Disable Write*******************************
     ******************************************************************************/
    private void WriteModeOff(){
        writeMode = false;
        nfcAdapter.disableForegroundDispatch(this);
    }

}
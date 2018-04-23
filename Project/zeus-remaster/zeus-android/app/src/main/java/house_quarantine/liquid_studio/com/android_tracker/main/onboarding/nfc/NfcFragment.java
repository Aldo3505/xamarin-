package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.nfc;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentQrBinding;
import house_quarantine.liquid_studio.com.android_tracker.databinding.NfcFragmentBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService.FirebaseListener;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr.QRViewModel;
import okhttp3.internal.framed.FrameReader;

/**
 * Created by joshua.a.t.tabilog on 2/6/18.
 */

public class NfcFragment extends Fragment implements NfcHandler {


    private Context base_context;



    @Override
    public void proceed() {

    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        base_context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        NfcFragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.nfc_fragment,container,false);
        binding.setHandler(this);

        return binding.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void intentFound(Intent intent, Context context) {

        base_context = context;
        if (intent.hasExtra(NfcAdapter.EXTRA_TAG)){
//            Toast.makeText(getActivity(),"NEW INTENT",Toast.LENGTH_LONG).show();
            toastNfcId(intent);
        }

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

    public void toastNfcId(Intent intent){
        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        if(tag == null){
            return;
        }
        String id = ByteArrayToHexString(tag.getId());
        Toast.makeText(base_context,R.string.toast_nfc_success,Toast.LENGTH_LONG).show();

    }

}

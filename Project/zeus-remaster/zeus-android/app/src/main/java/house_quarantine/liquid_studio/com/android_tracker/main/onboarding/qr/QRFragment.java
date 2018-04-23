package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentQrBinding;
import house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentQrWearableBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService.FirebaseListener;
import house_quarantine.liquid_studio.com.android_tracker.main.splashActivity.SplashComplete;
import house_quarantine.liquid_studio.com.android_tracker.main.onboarding.utils.UiThreadExecutor;

/**
 * A simple {@link Fragment} subclass.
 */
public class QRFragment extends Fragment implements Detector.Processor<Barcode>, QRHandler {

    private static final String TAG = QRFragment.class.getSimpleName();
    private CameraPreview preview;
    private CameraSource cameraSource;
    private QRViewModel model;
    private String unique_id = "S67128561X";
    private SharedPreferences prefs;
    private String macaddr;
    private boolean verified;


    public QRFragment newInstance(int id) {

        Bundle bundle = new Bundle();
        bundle.putInt("layout", id);
        QRFragment fragment = new QRFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void signIn() {
        Intent intent = new Intent(getActivity(), SplashComplete.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        new FirebaseListener(getActivity(),unique_id).getBleInfo();
        prefs = getActivity().getBaseContext().getSharedPreferences(unique_id,Context.MODE_PRIVATE);
        macaddr = prefs.getString("macaddr","");
        // Inflate the layout for this fragment
        model = new QRViewModel();
        if (this.getArguments().getInt("layout")==R.layout.fragment_qr){
            FragmentQrBinding binder;  binder =  DataBindingUtil.inflate(
                    inflater,  R.layout.fragment_qr,container,false);
            binder.setModel(model);
            binder.setHandler(this);
            preview = binder.cameraPreview;
            createCameraSource();
            return binder.getRoot();
        } else {
            FragmentQrWearableBinding binding =  DataBindingUtil.inflate(
                    inflater,  R.layout.fragment_qr_wearable,container,false);
            binding.setModel(model);
            binding.setHandler(this);
            preview = binding.cameraPreview;
            createCameraSource();
            return binding.getRoot();
        }


    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        preview.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        preview.stop();
        preview.release();
    }

    private void createCameraSource() {
        //Configure detector
        BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(getContext()).setBarcodeFormats(Barcode.QR_CODE).build();
        barcodeDetector.setProcessor(this);
        cameraSource = new CameraSource.Builder(getContext().getApplicationContext(), barcodeDetector)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(640, 640)
                .setAutoFocusEnabled(true)
                .setRequestedFps(30.0f)
                .build();
    }

    @Override
    public void release() {
        Log.d(TAG, "(released)");
    }

    @Override
    public void receiveDetections(Detector.Detections<Barcode> detections) {
        Log.d(TAG, "(receiveDetections)");
        final SparseArray<Barcode> barcodes = detections.getDetectedItems();
        //Just get the first
        if(barcodes.size() > 0) {

            final Barcode barcode = barcodes.valueAt(0);
            String barcodeDisplay = barcode.displayValue;
            verified = false;
            Log.d(TAG, "(receiveDetections) : " + barcode.displayValue);
            if (!barcodeDisplay.contains("{") || !barcodeDisplay.contains("[")){
             verified = false;
            }
            Gson gson = new Gson();
            List<Device> devices = null;

            try{
                devices = Arrays.asList(gson.fromJson(barcodeDisplay, Device[].class));
            }catch (JsonSyntaxException e){
                e.printStackTrace();
                verified = false;
            }


            Map<String , Device> deviceMap = new HashMap<>();
            for(Device device : devices){
                deviceMap.put(device.getAddress(), device);
                if (device.getAddress()==null || device.getType()==null || device.getName()==null){
                    verified = false;
                } else {
                    verified = true;
                }
            }


            UiThreadExecutor.instance().execute(new Runnable() {
                @Override
                public void run() {

                        if (verified){
                            preview.stop();
                            model.setScanning(false);

                            try{
                                Button next = getView().findViewById(R.id.next_done);
                                next.setVisibility(View.VISIBLE);
                                next.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        signIn();
                                    }
                                });
                                Toast.makeText(getContext(), getString(R.string.toast_scanned_wearable_success), Toast.LENGTH_SHORT).show();
                            }catch (NullPointerException e){
                                Toast.makeText(getContext(), getString(R.string.toast_scanned_qr_success), Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        } else{
                            Toast.makeText(getContext(), getString(R.string.toast_scanned_qr_fail), Toast.LENGTH_SHORT).show();
                        }

                }
            });

        }

    }
    @Override
    public void toggleScan() {
        if(model.isScanning()){
            preview.stop();
            model.setScanning(false);
        }else{
            preview.start(cameraSource);
            model.setDeviceAddress("");
            model.setDeviceName("");
            model.setHasInfo(false);
            model.setScanning(true);
        }
    }

    @Override
    public void registerDevice() {
        //TODO send the scanned device details here to Firebase
    }
}

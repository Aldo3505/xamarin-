package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.qr;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.CameraSource;

import java.io.IOException;

/**
 * Created by eugene.p.lozada on 1/26/18.
 */

public class CameraPreview extends SurfaceView {

    private static final String TAG = CameraPreview.class.getSimpleName();
    private boolean surfaceReady = false;
    private CameraSource cameraSource;
    private Context context;

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d(TAG, "(SurfaceHolder.Callback.surfaceCreated)");
                surfaceReady = true;
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.d(TAG, "(SurfaceHolder.Callback.surfacChanged)");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.d(TAG, "(SurfaceHolder.Callback.surfaceDestroyed)");
                surfaceReady = false;
            }
        });
    }

    public void start(@NonNull CameraSource source) {

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            this.cameraSource = source;
            if (surfaceReady) {
                Log.d(TAG, "(start) setting surface holder to camera source");
                try {
                    cameraSource.start(getHolder());
                    Size size = cameraSource.getPreviewSize();
                    Log.d(TAG, "(start) source size: " + size.toString());
                }catch(IOException ex){
                    Log.d(TAG, "(start) problem starting camera source: " + ex.getMessage());
                }
            }else{
                Log.d(TAG, "(start) surface is not ready");
            }
        }else{
            Log.d(TAG, "(start) camera permission not granted");
        }
    }

    public void stop() {

        if (cameraSource != null) {
            cameraSource.stop();
        }
    }

    public void release(){
        if (cameraSource != null) {
            cameraSource.release();
            cameraSource = null;
        }
    }
}

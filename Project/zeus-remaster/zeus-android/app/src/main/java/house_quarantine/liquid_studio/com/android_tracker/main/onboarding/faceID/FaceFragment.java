package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.databinding.FacialRegistrationBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.MainActivity;

/**
 * Created by joshua.a.t.tabilog on 1/30/18.
 */

public class FaceFragment extends Fragment implements FaceHandler {

    String mCurrentPhotoPath;
    private CircleImageView circleImageView;
    private ImageView imageView;
    private FaceViewModel model;
    private String COLL_ID = "home-quarantine";
    private final String TOKEN = "abc1234";
    private FloatingActionButton fab;
    private ProgressBar progressBar;
    private static final int REQUEST_TAKE_PHOTO = 1;
    private View rootView;
    private String device_name = Build.MANUFACTURER;

    @Override
    public void signIn() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FacialRegistrationBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.facial_registration, container, false);
        binding.setModel(model);
        binding.setHandler(this);
        rootView = binding.getRoot();
        imageView = (ImageView) rootView.findViewById(R.id.temp_image);
        circleImageView = rootView.findViewById(R.id.profile_image);
        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        return binding.getRoot();
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir     /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getContext().getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(getContext(),
                        "house_quarantine.liquid_studio.com.android_tracker",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO) {
            if (resultCode == getActivity().RESULT_OK) {
                Log.d("msg",mCurrentPhotoPath);

                imageView.setImageURI(Uri.parse(mCurrentPhotoPath));
                imageView.setDrawingCacheEnabled(true);
                imageView.buildDrawingCache();
                Bitmap bitmap = RotateBitmap(imageView.getDrawingCache());
                circleImageView.setImageBitmap(bitmap);
                circleImageView.setAlpha(1f);
                fab.setVisibility(View.INVISIBLE);
                Toast.makeText(getActivity(), "Face Profile registration Successful!", Toast.LENGTH_SHORT).show();
            }

            }

    }


    public Bitmap RotateBitmap(Bitmap source){

        if(device_name.equals("samsung")){
            Matrix matrix = new Matrix();
            matrix.postRotate(270);
            return Bitmap.createBitmap(source, 0, 0,  (int)(source.getWidth()*.75), source.getHeight(), matrix, true);

        }else {
            return source;
        }
    }
}

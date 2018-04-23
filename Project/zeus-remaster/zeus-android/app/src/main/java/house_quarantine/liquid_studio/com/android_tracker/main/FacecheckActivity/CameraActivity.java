package house_quarantine.liquid_studio.com.android_tracker.main.FacecheckActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Path;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v4.view.MotionEventCompat;
import android.util.Base64;
import android.util.JsonReader;
import android.util.JsonWriter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;
import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.main.NfcActivity.NfcManager;
import house_quarantine.liquid_studio.com.android_tracker.main.RetrofitInterface.AmazonInterface;
import house_quarantine.liquid_studio.com.android_tracker.main.RetrofitInterface.RequestBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joshua.a.t.tabilog on 1/22/18.
 */

public class CameraActivity extends Activity {

    String mCurrentPhotoPath;
    Intent takePictureIntent;
    private String device_name = Build.MANUFACTURER;
    private String unique_id = "S67128561X";
    private CircleImageView circleImageView;
    private ImageView imageView;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private String imageFileName;
    private String COLL_ID = "home-quarantine";
    private final String TOKEN = "abc1234";
    private Double similarity = 0.0;
    private String face_id= "";
    private SharedPreferences prefs;
    private FirebaseDatabase firebaseDatabase;
    private FloatingActionButton fab;
    private DatabaseReference face_ref;
    private DatabaseReference attempt_ref;
    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.face_rekog);
        Toast.makeText(this, "Camera Verficiation loaded.", Toast.LENGTH_SHORT).show();
        firebaseDatabase = FirebaseDatabase.getInstance();
        progressBar = findViewById(R.id.upload_progress);
        progressBar.setVisibility(View.INVISIBLE);
        face_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/"+unique_id+"/compliant/face_check");
        attempt_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/"+unique_id+"/attempts");
        storage = FirebaseStorage.getInstance();
        prefs = getApplicationContext().getSharedPreferences(unique_id,Context.MODE_PRIVATE);
        imageView = (ImageView) findViewById(R.id.temp_image);
        circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dispatchTakePictureIntent();
            }
        });

    }

    static final int REQUEST_TAKE_PHOTO = 1;

    private void dispatchTakePictureIntent() {
        takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while cre ating the File

            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "house_quarantine.liquid_studio.com.android_tracker",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);

            }
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        prefs = getApplicationContext().getSharedPreferences(unique_id,Context.MODE_PRIVATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            progressBar.setVisibility(View.VISIBLE);
            Log.d("msg",mCurrentPhotoPath);
            imageView.setImageURI(Uri.parse(mCurrentPhotoPath));
            imageView.setDrawingCacheEnabled(true);
            imageView.buildDrawingCache();
            Bitmap bitmap = RotateBitmap(imageView.getDrawingCache());
            circleImageView.setImageBitmap(bitmap);
            circleImageView.setAlpha(.5f);
            fab.setVisibility(View.INVISIBLE);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
            final byte[] dataPhoto = baos.toByteArray();
            String encodedImage = Base64.encodeToString(dataPhoto, Base64.DEFAULT);
            final RequestBody requestBody = new RequestBody();
            requestBody.setCollectionId(COLL_ID);
            requestBody.setimageBase64Str(encodedImage);
            requestBody.setToken(TOKEN);
            Log.d("BODY",requestBody.toString());
            service.searchImage(requestBody).enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    String temp = "";
                    String body = "";
                    progressBar.setVisibility(View.INVISIBLE);
                        if (response.body() != null) {
                            try {
                                try {
                                    body = response.body().string();
                                }catch (IOException e){
                                    e.printStackTrace();
                                }
                                JsonElement tempElement = new JsonParser().parse(body);

                                if (getFaceMatch(tempElement)){
                                    Toast.makeText(CameraActivity.this, R.string.toast_scanned_verification_face_success, Toast.LENGTH_LONG).show();
                                    face_ref.setValue(true);
                                    attempt_ref.child("face_check").setValue(true);
                                    circleImageView.setAlpha(1f);

                                }
                                else{
                                    Toast.makeText(CameraActivity.this, R.string.toast_scanned_verification_face_fail, Toast.LENGTH_LONG).show();
                                    fab.setVisibility(View.VISIBLE);
                                    face_ref.setValue(false);
                                    attempt_ref.child("face_check").setValue(false);
                                }

                            } catch (JsonIOException e) {
                                e.printStackTrace();
                            }

                        } else {
                            temp = response.message();
                            Log.d("!", temp);
                            fab.setVisibility(View.VISIBLE);
                            Toast.makeText(CameraActivity.this, "Face not detected! Try again!", Toast.LENGTH_LONG).show();
                            face_ref.setValue(false);
                            attempt_ref.child("face_check").setValue(false);
                        }

                        Log.d("!", temp);

                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(CameraActivity.this, "Face not detected! Try again!", Toast.LENGTH_LONG).show();
                    face_ref.setValue(false);
                    attempt_ref.child("face_check").setValue(false);
                }
            });
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        prefs = getApplicationContext().getSharedPreferences(unique_id,Context.MODE_PRIVATE);
    }

    @Override
    public void onBackPressed() {
        finish();

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );
        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit = new Retrofit.Builder()
            .client(new OkHttpClient().newBuilder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build())
            .baseUrl("https://us-central1-acn-pdc-liquid-rapid-app-dev.cloudfunctions.net")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    AmazonInterface service = retrofit.create(AmazonInterface.class);

    private Boolean getFaceMatch(JsonElement jsonElement){

        JsonArray tempArray = jsonElement.getAsJsonObject().getAsJsonObject("data").getAsJsonArray("FaceMatches");

        Boolean returnbool = false;
        for (int i = 0; i < tempArray.size(); i++) {
            JsonObject explrObject = tempArray.get(i).getAsJsonObject();
            similarity = explrObject.get("Similarity").getAsDouble();
            face_id = explrObject.getAsJsonObject("Face").get("FaceId").getAsString();

            String stored_id = prefs.getString("image_id","");
            Log.d("Stored ID", stored_id);
            Log.d("Face_id",face_id);
            if (similarity > 70){
                if (face_id.equals(stored_id)){
                    returnbool = true;
                }
            }
        }

        return returnbool;
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

package house_quarantine.liquid_studio.com.android_tracker.main.splashActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.main.MainActivity;

/**
 * Created by joshua.a.t.tabilog on 2/7/18.
 */

public class SplashComplete extends Activity {

    private Button imageButton;
    private FirebaseDatabase firebaseDatabase;
    private String unique_id = "S67128561X";
    private DatabaseReference main_ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_complete);
        imageButton = findViewById(R.id.proceed_button);
        firebaseDatabase = FirebaseDatabase.getInstance();
        main_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id);
        final Intent intent = new Intent(this,MainActivity.class);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SplashComplete.this,"Please do necessary verification steps to avoid delinquency",Toast.LENGTH_LONG).show();
                main_ref.child("delinquency").child("delinquent").setValue(false);
                main_ref.child("delinquency").child("timestamp").setValue(null);
                startActivity(intent);
                finish();
            }
        });
    }
}

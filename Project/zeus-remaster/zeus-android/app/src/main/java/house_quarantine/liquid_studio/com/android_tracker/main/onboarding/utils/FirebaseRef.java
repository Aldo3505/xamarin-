package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by eugene.p.lozada on 1/29/18.
 */

public class FirebaseRef {

    public static final String FIREBASE_DEVICE_ROOT = "devices";
    public static final FirebaseDatabase database;
    public static final DatabaseReference devices;
    static {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        database = FirebaseDatabase.getInstance();
        devices = database.getReference().child(FIREBASE_DEVICE_ROOT);
    }

}



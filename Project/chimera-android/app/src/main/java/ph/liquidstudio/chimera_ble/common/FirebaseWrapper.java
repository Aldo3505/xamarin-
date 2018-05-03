package ph.liquidstudio.chimera_ble.common;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by joshua.a.t.tabilog on 4/4/18.
 */

public class FirebaseWrapper {
    private String TAG = FirebaseWrapper.class.getSimpleName();
    private FirebaseDatabase firebaseDatabase;
    private Context context;
    private DatabaseReference mainRef;
    private String firebaseURI = "/CHIMERA/";

    public FirebaseWrapper(Context callingContext){

        //establish firebase instance
        context = callingContext;
        firebaseDatabase = FirebaseDatabase.getInstance();
        mainRef = firebaseDatabase.getReference(firebaseURI);

    }

    public DatabaseReference getMainRef(String path){

        return mainRef.child(path);
    }


    public void updatePath(String path, Object snapshot){
        mainRef.child(path).setValue(snapshot);
    }

    public void valueListener(String path, ValueEventListener valueEventListener){
        mainRef.child(path).addValueEventListener(valueEventListener);
    }

    public  void singleListener(String path, ValueEventListener valueEventListener) {
        mainRef.child(path).addListenerForSingleValueEvent(valueEventListener);
    }
}

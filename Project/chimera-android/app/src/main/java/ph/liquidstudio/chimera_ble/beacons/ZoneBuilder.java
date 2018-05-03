package ph.liquidstudio.chimera_ble.beacons;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.Map;

import ph.liquidstudio.chimera_ble.R;
import ph.liquidstudio.chimera_ble.common.FirebaseWrapper;
import ph.liquidstudio.chimera_ble.common.Resource;
import ph.liquidstudio.chimera_ble.proximity.Device;



public class ZoneBuilder {

    private static final String TAG = ZoneBuilder.class.getSimpleName();
    private Context context;;
    private Map<String, Device> deviceMap;
    private MutableLiveData<Resource<Map<String, Device>>> devicesLiveData;
    private FirebaseWrapper firebaseWrapper;



    public ZoneBuilder(Context callingContext){
        devicesLiveData = new MutableLiveData<>();
        deviceMap = new HashMap<>();
        context = callingContext;
        firebaseWrapper = new FirebaseWrapper(context);
    }




    private ValueEventListener devicesListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            Log.d(TAG, "(onDataChange) " + dataSnapshot.getValue());
            for (DataSnapshot child : dataSnapshot.getChildren()) {
                Device device = child.getValue(Device.class);
                if (device != null) {
                    deviceMap.put(child.getKey(), device);
                    Log.d(TAG, "(onDataChange) loaded " + child.getKey());
                }
            }
            devicesLiveData.postValue(Resource.success(deviceMap));
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            devicesLiveData.setValue(Resource.failed(databaseError.getMessage(), deviceMap));
        }
    };


    public LiveData<Resource<Map<String, Device>>> load() {
        firebaseWrapper.singleListener(context.getString(R.string.beacons_path),devicesListener);
        Log.d(TAG, "load: " + context.getString(R.string.beacons_path));
        return devicesLiveData;
    }


    public LiveData<Resource<Map<String, Device>>> getDevices() {
        return devicesLiveData;
    }

}

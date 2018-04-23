package house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.OnDisconnect;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by joshua.a.t.tabilog on 1/18/18.
 */

public class FirebaseListener {


    private String nfc_keys = "";
    private SharedPreferences prefs;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference main_ref;
    private String unique_id;
    private Context base_context;
    public static final String BEACON_KEYS = "keys_updated";
    public static final String MAC_BROADCAST_KEY = "bundle_key";

    public FirebaseListener(Context context, String id) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        unique_id = id;
        main_ref = firebaseDatabase.getReference("/ZEUS/DEV/USERS/" + unique_id);
        base_context = context;
    }


    public void getUserKeys() {

        main_ref.child("nfc").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                prefs = base_context.getSharedPreferences(unique_id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.remove("nfc_keys");
                for (DataSnapshot child : children) {
                    nfc_keys = nfc_keys + child.getValue() + ",";
                }
                if (nfc_keys.equals("")) {
                    editor.putString("nfc_keys", "");
                    editor.apply();
                    editor.commit();
                } else {
                    editor.putString("nfc_keys", nfc_keys.substring(0, nfc_keys.length() - 1));
                    editor.apply();
                    editor.commit();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        main_ref.child("ble_devices").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                prefs = base_context.getSharedPreferences(unique_id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.remove("macaddr");
                String mac_keys = "";
                for (DataSnapshot child : children) {
                    mac_keys = mac_keys + child.getKey() + ",";
                    Log.d("MSG-mac", mac_keys);
                    editor.putString(child.getKey().concat("type"), child.child("type").getValue() + "");
                    editor.apply();
                    editor.commit();
                }

                if (mac_keys.isEmpty()) {
                    editor.putString("macaddr", "");
                    editor.apply();
                    editor.commit();

                } else {
                    editor.putString("macaddr", mac_keys.substring(0, mac_keys.length() - 1));
                    editor.commit();

                }
                String[] temp = mac_keys.split(",");

                if (temp.length == dataSnapshot.getChildrenCount()){
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(base_context);
                    Intent localIntent = new Intent(BEACON_KEYS);
                    localIntent.putExtra(MAC_BROADCAST_KEY, mac_keys);
                    localBroadcastManager.sendBroadcast(localIntent);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


        main_ref.child("image_id").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                prefs = base_context.getSharedPreferences(unique_id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("image_id", ((String) dataSnapshot.getValue()));
                editor.apply();
                editor.commit();
                //  Log.d("MSG",prefs.getString("image_id",""));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        main_ref.child("threshold").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                prefs = base_context.getSharedPreferences(unique_id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("threshold", dataSnapshot.getValue() + "");
                editor.apply();
                editor.commit();
                //  Log.d("MSG",prefs.getString("threshold",""));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getBleInfo() {
        main_ref.child("ble_devices").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                prefs = base_context.getSharedPreferences(unique_id, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.remove("macaddr");
                String mac_keys = "";
                for (DataSnapshot child : children) {
                    mac_keys = mac_keys + child.getKey() + ",";
                    Log.d("MSG-mac", mac_keys);
                    editor.putString(child.getKey().concat("type"), child.child("type").getValue() + "");
                    editor.apply();
                    editor.commit();
                }

                if (mac_keys.isEmpty()) {
                    editor.putString("macaddr", "");
                    editor.apply();
                    editor.commit();

                } else {
                    editor.putString("macaddr", mac_keys.substring(0, mac_keys.length() - 1));
                    editor.commit();
                }
                LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(base_context);
                Intent localIntent = new Intent(BEACON_KEYS);
                localIntent.putExtra(MAC_BROADCAST_KEY, mac_keys);
                localBroadcastManager.sendBroadcast(localIntent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });


    }
}

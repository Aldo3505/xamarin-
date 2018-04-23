package house_quarantine.liquid_studio.com.android_tracker.main;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import house_quarantine.liquid_studio.com.android_tracker.databinding.BeaconAdPacketBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.BluetoothScanner.BeaconScanData;


/**
 * Created by eugene.p.lozada on 1/19/18.
 */

public class BeaconListAdapter extends RecyclerView.Adapter<BeaconListAdapter.ViewHolder> {
    private static final String TAG = BeaconListAdapter.class.getSimpleName();
    private List<BeaconScanData> beacons;

    public BeaconListAdapter() {
        beacons = new ArrayList<>();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        BeaconAdPacketBinding binder;

        public ViewHolder(BeaconAdPacketBinding binder) {
            super(binder.getRoot());
            this.binder = binder;
        }

        public void bind(BeaconScanData beacon) {
            binder.setModel(beacon);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        BeaconAdPacketBinding binding = BeaconAdPacketBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(beacons.get(position));
    }

    @Override
    public int getItemCount() {
        return beacons.size();
    }

    public void setBeacon(BeaconScanData newBeacon) {

        boolean isNewBeacon = true;
        Log.d("BEACON SIZE",beacons.size()+"");
        for (int i = 0; i < beacons.size(); i++) {
            BeaconScanData beacon = beacons.get(i);
            Log.d("Difference"," "+beacon.getAddress());


            Long newDate = new Date().getTime();
            Long temp = newDate - beacons.get(i).getTimeStamp();
            int dif = temp.intValue();


            if (dif > 10000) {
                beacon.setAccuracy(1000);
                beacon.setThreshold(1000);
            }
            if (newBeacon.getAddress().equals(beacon.getAddress())) {

                beacon.copy(newBeacon);
                isNewBeacon = false;
                notifyDataSetChanged();
            }
        }

        if(isNewBeacon){
            beacons.add(newBeacon);
            notifyDataSetChanged();
        }




    }
}

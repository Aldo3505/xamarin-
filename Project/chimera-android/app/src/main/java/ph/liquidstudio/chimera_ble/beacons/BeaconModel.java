package ph.liquidstudio.chimera_ble.beacons;

import ph.liquidstudio.chimera_ble.proximity.Location;

public class BeaconModel {

    private float accuracy;
    private String address;
    private Location location;



    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }
}

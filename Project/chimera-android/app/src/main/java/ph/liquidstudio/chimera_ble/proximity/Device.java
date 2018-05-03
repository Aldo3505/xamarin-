package ph.liquidstudio.chimera_ble.proximity;

import ph.liquidstudio.chimera_ble.beacons.IBeaconScanData;

/**
 * Created by eugene.p.lozada on 2/4/18.
 */

public class Device {

    private String id;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

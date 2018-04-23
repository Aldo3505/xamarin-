package house_quarantine.liquid_studio.com.android_tracker.main.FirebaseService;

import java.util.Map;

/**
 * Created by joshua.a.t.tabilog on 1/10/18.
 */

public class FirebaseObject {

    private String date;
    private String name;
    private double battery_level;
    private boolean connection_status;

    public boolean isConnection_status() {
        return connection_status;
    }

    public void setConnection_status(boolean connection_status) {
        this.connection_status = connection_status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBattery_level() {
        return battery_level;
    }

    public void setBattery_level(double battery_level) {
        this.battery_level = battery_level;
    }

}

package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.faceID;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by joshua.a.t.tabilog on 1/30/18.
 */

public class FaceViewModel extends BaseObservable {

    public String getFace_id() {
        return face_id;
    }

    public void setFace_id(String face_id) {
        this.face_id = face_id;
    }

    @Bindable
    private String face_id;

}

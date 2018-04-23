package house_quarantine.liquid_studio.com.android_tracker.main.RetrofitInterface;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by joshua.a.t.tabilog on 1/24/18.
 * Request Body for Retrofit
 */

public class RequestBody {

    @SerializedName("token")
    private String token;
    @SerializedName("collectionId")
    private String collectionId;
    @SerializedName("imageBase64Str")
    private String imageBase64Str;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    public String imageBase64Str() {
        return imageBase64Str;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getImageBase64Str() {
        return imageBase64Str;
    }

    public void setImageBase64Str(String imageBase64Str) {
        this.imageBase64Str = imageBase64Str;
    }

    public void setimageBase64Str(String imageBase64Str) {
        this.imageBase64Str = imageBase64Str;
    }
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

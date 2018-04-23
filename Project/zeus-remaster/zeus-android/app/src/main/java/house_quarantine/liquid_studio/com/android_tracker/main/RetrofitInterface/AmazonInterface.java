package house_quarantine.liquid_studio.com.android_tracker.main.RetrofitInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by joshua.a.t.tabilog on 1/24/18.
 *
 * Retrofit Interface for Amazon APIs
 */

public interface AmazonInterface {

    @POST("/machineLearning/aws-rekognition/indexFaces")
    Call<ResponseBody> indexImage(@Body RequestBody requestBody);

    @POST("/machineLearning/aws-rekognition/searchFacesByImage")
    Call<ResponseBody> searchImage(@Body RequestBody requestBody);
}

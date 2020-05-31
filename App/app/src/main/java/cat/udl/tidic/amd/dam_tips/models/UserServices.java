package cat.udl.tidic.amd.dam_tips.models;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

class UserServices {

    @POST("/questions/{question_id}")
    Call<Void> postQuestion(@Header("Authorization") String tokenAuth, @Body JsonObject questionJson);
}

package cat.udl.tidic.amd.dam_tips.dao;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AccountDAO {

    @POST("/questions/post/")
    Call<Void> postQuestion(@Header ("Authorization") String tokenAuth,
                          @Body Question favour);


    @POST("account/create_token")
    Call<JsonObject> createTokenUser();

    @POST("account/delete_token")
    Call<Void> deleteTokenUser(@Body JsonObject token);

}

package cat.udl.tidic.amd.dam_tips.models;

import android.content.Context;

import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Objects;

import cat.udl.tidic.amd.dam_tips.network.RetrofitClientInstance;
import cat.udl.tidic.amd.dam_tips.preferences.PreferencesProvider;
import cat.udl.tidic.amd.dam_tips.views.Uploadquestion;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadQuestionModel {
    private UserServices userService;
    private Context c;
    public UploadQuestionModel(Context c)
    {
        this.c = c;
        userService = RetrofitClientInstance.
                getRetrofitInstance().create(UserServices.class);
    }

    public void postQuestion (DataModel.Favour currentFavourData, Uploadquestion upFav)
    {
        String token = PreferencesProvider.providePreferences().getString("token","");
        JsonObject user_json = new JsonObject();
        user_json.addProperty("id", currentQuestionData.id);
        user_json.addProperty("name", currentFavourData.question);
        user_json.addProperty("category", currentFavourData.category);
        Call<Void> call = userService.postQuestion(token,user_json);
        LoadingPanel.enableLoading(c,true);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response)
            {
                if (response.code() == 200)
                {
                    LoadingPanel.sendMessage(c.getString(R.string.questionUploaded));
                    upQuestion.onSucces();
                }

                LoadingPanel.enableLoading(c,false);
            }

           });
    }

}

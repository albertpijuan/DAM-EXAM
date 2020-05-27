package cat.udl.tidic.amd.dam_tips.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;

import cat.udl.tidic.amd.dam_tips.dao.AccountDAO;
import cat.udl.tidic.amd.dam_tips.dao.AccountDAOImpl;
import cat.udl.tidic.amd.dam_tips.preferences.PreferencesProvider;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountRepo {

    private String TAG = "AccountRepo";

    private AccountDAO accountDAO;
    private MutableLiveData<String> mResponseLogin;

    public AccountRepo() {
        this.accountDAO = new AccountDAOImpl();
        this.mResponseLogin = new MutableLiveData<>();
    }


    public void createTokenUser(){


        accountDAO.createTokenUser().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                int code = response.code();
                Log.d(TAG,  "createTokenUser() -> ha rebut del backend un codi:  " + code);

                if (code == 200 ){
                    try {
                        String authToken = response.body().string().split(":")[1];
                        authToken=authToken.substring(2,authToken.length()-2);
                        Log.d(TAG,  "createTokenUser() -> ha rebut el token:  " + authToken);
                        mResponseLogin.setValue(authToken);
                        PreferencesProvider.providePreferences().edit().
                                putString("token", authToken).apply();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        String error_msg = "Error: " + response.errorBody().string();
                        Log.d(TAG,  "createTokenUser() -> ha rebut l'error:  " + error_msg);
                        PreferencesProvider.providePreferences().edit().remove("token").apply();
                        mResponseLogin.setValue(error_msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String error_msg = "Error: " + t.getMessage();
                Log.d(TAG,  "createTokenUser() onFailure() -> ha rebut el missatge:  " + error_msg);
                PreferencesProvider.providePreferences().edit().remove("token").apply();
                mResponseLogin.setValue(error_msg);
            }

        });
    }

    public MutableLiveData<String> getmResponseLogin() {
        return mResponseLogin;
    }
}

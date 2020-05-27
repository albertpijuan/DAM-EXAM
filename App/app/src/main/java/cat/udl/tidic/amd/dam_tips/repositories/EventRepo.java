package cat.udl.tidic.amd.dam_tips.repositories;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.util.List;

import cat.udl.tidic.amd.dam_tips.dao.AccountDAO;
import cat.udl.tidic.amd.dam_tips.dao.AccountDAOImpl;
import cat.udl.tidic.amd.dam_tips.dao.EventDAO;
import cat.udl.tidic.amd.dam_tips.dao.EventDAOImpl;
import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.preferences.PreferencesProvider;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventRepo {

    private String TAG = "EventRepo";

    private EventDAO eventDAO;
    private MutableLiveData<List<Event>> mResponseEvents;

    public EventRepo() {
        this.eventDAO = new EventDAOImpl();
        this.mResponseEvents = new MutableLiveData<>();
    }


    public void getEvents(){

        eventDAO.getEvents().enqueue(new Callback<List<Event>>() {


            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

                int code = response.code();
                Log.d(TAG,  "getEvents() -> ha rebut del backend un codi:  " + code);

                if (code == 200 ){
                    List<Event> events = response.body();
                    Log.d(TAG,  "getEvents() -> ha rebut una llista de mida: "+ events.size());
                    mResponseEvents.setValue(events);
                }
                else{
                    try {
                        String error_msg = "Error: " + response.errorBody().string();
                        Log.d(TAG,  "createTokenUser() -> ha rebut l'error:  " + error_msg);
                        mResponseEvents.setValue(null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                String error_msg = "Error: " + t.getMessage().toString();
                Log.d(TAG,  "getEvents() onFailure() -> ha rebut el missatge:  " + error_msg);
                mResponseEvents.setValue(null);
            }
        });
    }

    public MutableLiveData<List<Event>> getmResponseEvents() {
        return mResponseEvents;
    }
}

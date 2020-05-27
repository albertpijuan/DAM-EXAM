package cat.udl.tidic.amd.dam_tips.dao;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.models.Event;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


public interface EventDAO {

    @GET("events/list")
    Call<List<Event>> getEvents();
}

package cat.udl.tidic.amd.dam_tips.dao;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.network.RetrofitClientInstance;
import retrofit2.Call;
import retrofit2.Retrofit;

public class EventDAOImpl implements EventDAO{

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<List<Event>> getEvents() {
        return  retrofit.create(EventDAO.class).getEvents();
    }
}

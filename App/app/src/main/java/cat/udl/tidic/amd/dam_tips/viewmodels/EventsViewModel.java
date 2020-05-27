package cat.udl.tidic.amd.dam_tips.viewmodels;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.repositories.EventRepo;

public class EventsViewModel {

    private final String TAG = "EventsViewModel";
    private EventRepo eventRepo;

    public EventsViewModel() {
        eventRepo = new EventRepo();
    }

    public void getEvents(){
        eventRepo.getEvents();
    }

    public MutableLiveData<List<Event>> getResponseEvents() {
        return this.eventRepo.getmResponseEvents();
    }


}

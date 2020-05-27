package cat.udl.tidic.amd.dam_tips.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.adapters.EventAdapter;
import cat.udl.tidic.amd.dam_tips.adapters.EventDiffCallback;
import cat.udl.tidic.amd.dam_tips.models.Event;

public class EventsListActivity extends EventsActivity {

    private RecyclerView eventsListView;
    private EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected void initView() {
        super.initView(R.layout.activity_event_list);
        eventsListView = findViewById(R.id.eventsList);
        //eventsListView.setLayoutManager(new LinearLayoutManager(this));
        eventsListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        eventAdapter = new EventAdapter(new EventDiffCallback());
        eventsListView.setAdapter(eventAdapter);

        eventsViewModel.getResponseEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {
                eventAdapter.submitList(events);
            }
        });

        this.currentLocation.observe(this, new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                eventAdapter.setCurrentLocation(location);
                eventAdapter.notifyDataSetChanged();
            }
        });

        refreshList();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

}

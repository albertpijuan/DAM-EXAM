package cat.udl.tidic.amd.dam_tips.adapters;

import android.app.Activity;
import android.location.Location;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.models.EventStatus;
import cat.udl.tidic.amd.dam_tips.models.EventType;
import cat.udl.tidic.amd.dam_tips.views.LocationActivity;

public class EventAdapter extends ListAdapter<Event, EventAdapter.EventHolder> {

    private final static String TAG ="EventAdapter";
    private Location currentLocation;
    private EventCommonHolder eventHolder;


    public EventAdapter(@NonNull DiffUtil.ItemCallback<Event> diffCallback) {
        super(diffCallback);
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_window,
                null, false);
        return new EventHolder(itemView);
    }

//    @Override
//    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
//        final Event cEvent = (Event) getItem(position);
//        Log.d(TAG, "onBindViewHolder() -> cEvent: " + cEvent);
//        holder.eventName.setText(cEvent.getName());
//        holder.eventDescription.setText(cEvent.getDescription());
//        holder.eventStatus.setText( cEvent.getStatus().name());
//
//        holder.eventStatusColor.setBackground(ContextCompat.getDrawable(
//                holder.eventStatusColor.getContext(),
//                EventStatus.getColourResource(cEvent.getStatus())));
//
//        holder.eventStatus.setText(cEvent.getStatus().getName());
//        holder.eventStatus.setTextColor(ContextCompat.getColor(
//                holder.eventStatus.getContext(),
//                EventStatus.getColourResource(cEvent.getStatus())));
//
//        Log.d(TAG, "onBindViewHolder() -> cEvent: " + cEvent.getPoster_url());
//        Picasso.get().load(cEvent.getPoster_url()).into(holder.eventPoster);
//
//        holder.eventType.setImageResource(EventType.getImageResource(cEvent.getType()));
//
//        Log.d(TAG, "onBindViewHolder() -> cLocation: " + currentLocation);
//        if ( currentLocation != null) {
//            float[] distance = new float[1];
//            Location.distanceBetween(currentLocation.getLatitude(), currentLocation.getLongitude(),
//                    cEvent.getLatitude(), cEvent.getLongitude(), distance);
//
//            Log.d(TAG, "onBindViewHolder() -> distance: " + distance[0]);
//            holder.distanceToEvent.setText((int) (distance[0] / 1000) + " km");
//        }
//
//    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        final Event cEvent = (Event) getItem(position);
        Log.d(TAG, "onBindViewHolder() -> cEvent: " + cEvent);
        eventHolder.bindHolder(cEvent, currentLocation);
    }


    class EventHolder extends RecyclerView.ViewHolder {


        public EventHolder(@NonNull View itemView) {
            super(itemView);
            eventHolder = new EventCommonHolder(itemView);
        }
    }
//    class EventHolder extends RecyclerView.ViewHolder {
//
//        private TextView eventName;
//        private TextView eventDescription;
//        private ImageView eventPoster;
//        private ImageView eventType;
//        private TextView eventStatus;
//        private TextView eventStatusColor;
//        private TextView distanceToEvent;
//
//        public EventHolder(@NonNull View itemView) {
//            super(itemView);
//            eventName = itemView.findViewById(R.id.eventNameInfo);
//            eventDescription = itemView.findViewById(R.id.eventDescriptionInfo);
//            eventPoster = itemView.findViewById(R.id.eventPosterInfo);
//            eventStatus = itemView.findViewById(R.id.eventStatusInfo);
//            eventStatusColor = itemView.findViewById(R.id.eventStatusColourInfo);
//            eventType = itemView.findViewById(R.id.eventTypeIconInfo);
//            distanceToEvent = itemView.findViewById(R.id.eventDistanceToInfo);
//        }
//    }
}

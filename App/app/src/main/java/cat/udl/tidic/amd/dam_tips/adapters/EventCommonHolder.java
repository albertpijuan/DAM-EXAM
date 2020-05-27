package cat.udl.tidic.amd.dam_tips.adapters;

import android.location.Location;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.squareup.picasso.Picasso;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.models.EventStatus;
import cat.udl.tidic.amd.dam_tips.models.EventType;

public class EventCommonHolder {

    private final String TAG = "EventHolder";

    private TextView eventName;
    private TextView eventDescription;
    private ImageView eventPoster;
    private ImageView eventType;
    private TextView eventStatus;
    private TextView eventStatusColor;
    private TextView distanceToEvent;

    public EventCommonHolder(@NonNull View itemView) {
        eventName = itemView.findViewById(R.id.eventNameInfo);
        eventDescription = itemView.findViewById(R.id.eventDescriptionInfo);
        eventPoster = itemView.findViewById(R.id.eventPosterInfo);
        eventStatus = itemView.findViewById(R.id.eventStatusInfo);
        eventStatusColor = itemView.findViewById(R.id.eventStatusColourInfo);
        eventType = itemView.findViewById(R.id.eventTypeIconInfo);
        distanceToEvent = itemView.findViewById(R.id.eventDistanceToInfo);
    }


    public void bindHolder(Event e, Location currentLocation) {

        Log.d(TAG, "bindHolder() -> Event: " + e);
        this.eventName.setText(e.getName());
        this.eventDescription.setText(e.getDescription());
        this.eventStatus.setText(e.getStatus().name());

        this.eventStatusColor.setBackground(ContextCompat.getDrawable(
                this.eventStatusColor.getContext(),
                EventStatus.getColourResource(e.getStatus())));

        this.eventStatus.setText(e.getStatus().getName());
        this.eventStatus.setTextColor(ContextCompat.getColor(
                this.eventStatus.getContext(),
                EventStatus.getColourResource(e.getStatus())));

        Log.d(TAG, "onBindViewHolder() -> cEvent: " + e.getPoster_url());
        Picasso.get().load(e.getPoster_url()).into(this.eventPoster);

        this.eventType.setImageResource(EventType.getImageResource(e.getType()));

        Log.d(TAG, "onBindViewHolder() -> cLocation: " + currentLocation);
        if (currentLocation != null) {
            float[] distance = new float[1];
            Location.distanceBetween(currentLocation.getLatitude(), currentLocation.getLongitude(),
                    e.getLatitude(), e.getLongitude(), distance);

            Log.d(TAG, "onBindViewHolder() -> distance: " + distance[0]);
            this.distanceToEvent.setText((int) (distance[0] / 1000) + " km");
        }

    }

}



package cat.udl.tidic.amd.dam_tips.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.models.Event;


public class MapCustomInfoWindowsAdapter implements GoogleMap.InfoWindowAdapter {

    private final View customView;
    private List<Event> events;
    private EventCommonHolder eventHolder;


    public MapCustomInfoWindowsAdapter(List<Event> events, Context context) {
        this.events = events;
        customView = LayoutInflater
                .from(context).inflate(R.layout.info_window, null);
        eventHolder = new EventCommonHolder(customView);
    }


    @Override
    public View getInfoContents(final Marker marker) {
        int position = Integer.parseInt(marker.getSnippet());
        eventHolder.bindHolder(events.get(position), null);
//        TextView eventName= (TextView) customView.findViewById(R.id.eventNameInfo);
//        TextView eventDescription= (TextView) customView.findViewById(R.id.eventDescriptionInfo);
//        ImageView eventType = customView.findViewById(R.id.eventTypeIconInfo);
//        ImageView eventPoster = customView.findViewById(R.id.eventPosterInfo);
//        TextView eventStatus = customView.findViewById(R.id.eventStatusInfo);
//        TextView eventStatusColor = customView.findViewById(R.id.eventStatusColourInfo);
//        TextView distanceToEvent = customView.findViewById(R.id.eventDistanceToInfo);
//
//        eventStatusColor.setBackground(ContextCompat.getDrawable(customView.getContext(),
//                EventStatus.getColourResource(events.get(position).getStatus())));
//
//        eventStatus.setText(events.get(position).getStatus().getName());
//        eventStatus.setTextColor(ContextCompat.getColor(customView.getContext(),
//                EventStatus.getColourResource(events.get(position).getStatus())));
//
//        eventName.setText(events.get(position).getName());
//        eventDescription.setText(events.get(position).getDescription());
//
//        Picasso.get().load(events.get(position).getPoster_url()).into(eventPoster);
//        eventType.setImageResource(EventType.getImageResource(events.get(position).getType()));
        return customView;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

}

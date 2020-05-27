package cat.udl.tidic.amd.dam_tips.views;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.adapters.MapCustomInfoWindowsAdapter;
import cat.udl.tidic.amd.dam_tips.models.Event;
import cat.udl.tidic.amd.dam_tips.models.EventStatus;
import cat.udl.tidic.amd.dam_tips.models.EventType;

public class EventsMapActivity extends EventsActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }


    protected void initView() {
        super.initView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        eventsViewModel.getResponseEvents().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {
                insertMarkers(events);
            }
        });


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap; refreshList();
    }



    private void insertMarkers(List<Event> events) {
        final LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (int i = 0; i < events.size(); i++) {
            final LatLng position = new LatLng(events.get(i).getLatitude(),
                    events.get(i).getLongitude());
            final MarkerOptions options = new MarkerOptions().position(position)
                    .snippet(String.valueOf(i))
                    .icon(BitmapDescriptorFactory.fromBitmap(getMarkerBitmapFromView(events.get(i))));

            mMap.addMarker(options);
            builder.include(position);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
        }
        mMap.setInfoWindowAdapter(new MapCustomInfoWindowsAdapter(events, getApplicationContext()));
    }

    private Bitmap getMarkerBitmapFromView(Event e) {

        View customMarkerView = ((LayoutInflater) getApplicationContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.map_marker, null);

        TextView eventName = customMarkerView.findViewById(R.id.event_name_marker);
        eventName.setText(e.getName());

        ImageView eventType = customMarkerView.findViewById(R.id.event_type_marker);
        eventType.setImageResource(EventType.getImageResource(e.getType()));

        TextView eventStatusColor = customMarkerView.findViewById(R.id.event_status_marker);
        eventStatusColor.setBackground(ContextCompat.getDrawable(customMarkerView.getContext(),
                EventStatus.getColourResource(e.getStatus())));

        customMarkerView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        customMarkerView.layout(0, 0, customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight());
        customMarkerView.buildDrawingCache();

        Bitmap returnedBitmap = Bitmap.createBitmap(customMarkerView.getMeasuredWidth(), customMarkerView.getMeasuredHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN);
        Drawable drawable = customMarkerView.getBackground();
        if (drawable != null)
            drawable.draw(canvas);
        customMarkerView.draw(canvas);
        return returnedBitmap;
    }






}

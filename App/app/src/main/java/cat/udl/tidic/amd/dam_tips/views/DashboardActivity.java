package cat.udl.tidic.amd.dam_tips.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cat.udl.tidic.amd.dam_tips.R;

public class DashboardActivity extends CustomActivty {

    //private final String TAG = "DashboardActivity";
    private CardView eventsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initView();
    }


    protected void initView(){

        eventsView = findViewById(R.id.cardViewMap);
        eventsView.setOnClickListener(v -> goTo(EventsListActivity.class));

    }

//    public void goTo(Class _class){
//        Log.d(TAG, "goTo() -> Navigate to " + _class.getSimpleName());
//        Intent intent = new Intent(this, _class);
//        startActivity(intent);
//    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }

}

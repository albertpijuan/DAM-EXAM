package cat.udl.tidic.amd.dam_tips.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.viewmodels.EventsViewModel;

public class EventsActivity extends LocationActivity {

    protected EventsViewModel eventsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventsViewModel = new EventsViewModel();
    }

    protected void initView(int layout_resource) {
        setContentView(layout_resource);
    }


    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.events_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_list) {
            if (this.getClass() == EventsListActivity.class){
                goTo(EventsMapActivity.class);
            }else{
                goTo(EventsListActivity.class);
            }
        }
        return super.onOptionsItemSelected(item);
    }

//    protected void goTo(Class _class){
//        Intent intent = new Intent(this, _class);
//        startActivity(intent);
//    }

    protected void refreshList(){
        eventsViewModel.getEvents();
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onBackPressed(){
        goTo(DashboardActivity.class);
    }
}

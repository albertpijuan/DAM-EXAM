package cat.udl.tidic.amd.dam_tips.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.utils.EULA;
import cat.udl.tidic.amd.dam_tips.viewmodels.MainActivityViewModel;

public class MainActivity extends CustomActivty {

    //protected final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel();

        if (mainActivityViewModel.isCurrentLogIn()) {
            Log.d(TAG, "onCreate() -> El usuario ya tiene token, por lo tanto entro." );
            goTo(DashboardActivity.class);
        }
        else {
            Log.d(TAG, "onCreate() -> El usuario no tiene token, por lo tanto ir a login." );
            goTo(LoginActivity.class);
        }
    }

//    public void goTo(Class _class){
//        Intent intent = new Intent(this, _class);
//        startActivity(intent);
//    }

}

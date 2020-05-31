package cat.udl.tidic.amd.dam_tips.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cat.udl.tidic.amd.dam_tips.R;
import cat.udl.tidic.amd.dam_tips.viewmodels.LoginViewModel;

public class DashboardActivity extends CustomActivty {

    private Button disconnect;
    private LoginViewModel loginViewModel;
    private CardView admin;
    private int contador = 0;
    private TextView Resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initView();
        Resultat = findViewById(R.id.contador_questions);

        try{
            Bundle extras = getIntent().getExtras();
            int i = extras.getInt("contador");
            contador = i;
            Resultat.setText(String.valueOf(i));

        }catch (Exception e){

            System.out.println(e);
        }

        admin = findViewById(R.id.cardViewRanking);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, AdminActivity.class);
                intent.putExtra("contador",contador);
                startActivity(intent);
            }
        });
    }

    protected void initView(){
        loginViewModel = new LoginViewModel();
        disconnect = findViewById(R.id.disconnect);
        disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    loginViewModel.logout();
            }
        });

        loginViewModel.getResponseLogin().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (!s.startsWith("Error")) {
                    goTo(LoginActivity.class);
                }
            }
        });

        admin = findViewById(R.id.cardViewAdmin);
        admin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), AdminActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }

    @Override
    public void onBackPressed(){
        finishAffinity();
    }

}

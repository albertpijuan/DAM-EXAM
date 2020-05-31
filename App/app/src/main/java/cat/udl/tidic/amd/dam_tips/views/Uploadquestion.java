package cat.udl.tidic.amd.dam_tips.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cat.udl.tidic.amd.dam_tips.R;

public class Uploadquestion extends AppCompatActivity {

    public Button uploadquestion;
    public int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadquestion);
        uploadquestion = findViewById(R.id.uploadquestion);

        Bundle extras = getIntent().getExtras();
        contador = extras.getInt("contador");
        uploadquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contador = contador + 1;

                Intent i = new Intent(Uploadquestion.this, DashboardActivity.class);
                i.putExtra("contador", contador);
                startActivity(i);
            }
        });
    }
}
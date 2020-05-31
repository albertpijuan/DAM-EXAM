package cat.udl.tidic.amd.dam_tips.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import javax.xml.parsers.SAXParser;

import cat.udl.tidic.amd.dam_tips.R;

public class AdminActivity extends AppCompatActivity {
    private Button addQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Bundle extras = getIntent().getExtras();
        final int current_contador = extras.getInt("contador");

        addQuestion = findViewById(R.id.crearquestion);
        addQuestion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminActivity.this, Uploadquestion.class);
                intent.putExtra("contado",current_contador);
                startActivity(intent);
            }
        });
    }
}
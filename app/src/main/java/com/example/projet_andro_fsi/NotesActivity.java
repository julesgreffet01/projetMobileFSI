package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {

    private UserDataSource dataSource;
    private Button btnBil1, btnBil2, btnAccueil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
        dataSource.open();
    }

    private void initialisation(){
        btnBil1 = (Button) findViewById(R.id.btnBilan1);
        btnBil2 = (Button) findViewById(R.id.btnBilan2);
        btnAccueil = (Button) findViewById(R.id.btnNotesAccueil);

        btnAccueil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });

        btnBil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, Bilan1Activity.class);
                startActivity(intent);
            }
        });

        btnBil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesActivity.this, Bilan2Activity.class);
                startActivity(intent);
            }
        });
    }
}

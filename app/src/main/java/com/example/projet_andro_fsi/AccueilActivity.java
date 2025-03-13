package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    private UserDataSource dataSource;
    private Button btnNote, btnInfos, btnDeco;
    private TextView textViewBonjour;
    private String bonjour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accueil);
        initDB();
        initialisation();
    }
    private void initDB(){
        dataSource = new UserDataSource(this);
    }

    private void initialisation(){
        btnNote = (Button) findViewById(R.id.btnAccueilNotes);
        btnInfos = (Button) findViewById(R.id.btnAccueilInfo);
        btnDeco = (Button) findViewById(R.id.btnDeco);
        textViewBonjour = (TextView) findViewById(R.id.textViewBonjour);

        dataSource.open();
        User user = dataSource.getUser();
        dataSource.close();

        bonjour = "Bonjour " + user.getPrenomUti();
        textViewBonjour.setText(bonjour);

        btnDeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSource.open();
                dataSource.clear();
                dataSource.close();
                Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, InfosActivity.class);
                startActivity(intent);
            }
        });

        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
    }
}

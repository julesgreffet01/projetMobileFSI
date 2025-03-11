package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bilan1Activity extends AppCompatActivity {

    private UserDataSource dataSource;
    private TextView textViewLibelleBil1, textViewNoteBil1, textViewNoteBil1Ent, textViewBil1Ora, textViewBil1Rem, textViewBil1Date;
    private String lib, rem, date;

    private Button btnAccueilBil1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilan1);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
        dataSource.open();
    }

    private void initialisation(){
        textViewLibelleBil1 = (TextView) findViewById(R.id.textViewLibelleBil1);
        textViewNoteBil1 = (TextView) findViewById(R.id.textViewNoteBil1);
        textViewNoteBil1Ent = (TextView) findViewById(R.id.textViewNoteBil1Ent);
        textViewBil1Ora = (TextView) findViewById(R.id.textViewBil1Ora);
        textViewBil1Rem = (TextView) findViewById(R.id.textViewBil1Rem);
        textViewBil1Date = (TextView) findViewById(R.id.textViewBil1Date);
        btnAccueilBil1 = (Button) findViewById(R.id.btnAccueilBil1);

        User user = dataSource.getUser();

        lib = user.getLibBil1();
        textViewLibelleBil1.setText(lib);
        if(user.getNotBil1() == 100){
            String note = "-";
            textViewNoteBil1.setText(note);
        } else {
            float note = user.getNotBil1();
            textViewNoteBil1.setText(note+"");
        }
        if(user.getNoteEntBil1() == 100){
            String noteEnt = "-";
            textViewNoteBil1Ent.setText(noteEnt);
        } else {
            float noteEnt = user.getNoteEntBil1();
            textViewNoteBil1Ent.setText(noteEnt+"");
        }
        if(user.getNoteOralBil1() == 100){
            String noteOra = "-";
            textViewBil1Ora.setText(noteOra);
        } else {
            float noteOra = user.getNoteOralBil1();
            textViewBil1Ora.setText(noteOra+"");
        }
        rem = user.getRemarqueBil1();
        textViewBil1Rem.setText(rem);
        date = user.getDateBil1();
        textViewBil1Date.setText(date);

        btnAccueilBil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bilan1Activity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
    }
}

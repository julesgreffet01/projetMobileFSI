package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class AlternanceActivity extends AppCompatActivity {

    private UserDataSource dataSource;
    private TextView textViewNomEnt, textViewTelEnt, textViewAdrEnt, textViewMailEnt, textViewNomPreMA, textViewTelMA, textViewMailMA;
    private Button btnAccueilAlternance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alternance);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
    }

    private void initialisation(){
        textViewNomEnt = (TextView) findViewById(R.id.textViewNomEnt);
        textViewTelEnt = (TextView) findViewById(R.id.textViewTelEnt);
        textViewAdrEnt = (TextView) findViewById(R.id.textViewAdrEnt);
        textViewMailEnt = (TextView) findViewById(R.id.textViewMailEnt);
        textViewNomPreMA = (TextView) findViewById(R.id.textViewNomPreMA);
        textViewTelMA = (TextView) findViewById(R.id.textViewTelMA);
        textViewMailMA = (TextView) findViewById(R.id.textViewMailMA);
        btnAccueilAlternance = (Button) findViewById(R.id.btnAccueilAlternance);
        dataSource.open();
        User user = dataSource.getUser();
        dataSource.close();

        textViewNomEnt.setText(user.getNomEnt());
        textViewTelEnt.setText(user.getTelEnt());
        textViewAdrEnt.setText(user.getAdresseEnt());
        textViewMailEnt.setText(user.getMailEnt());
        String np = user.getPrenomMA()+" "+user.getNomMA();
        textViewNomPreMA.setText(np);
        textViewTelMA.setText(user.getTelMA());
        textViewMailMA.setText(user.getMailMA());

        btnAccueilAlternance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlternanceActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
    }
}

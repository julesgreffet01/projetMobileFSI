package com.example.projet_andro_fsi;

import android.os.Bundle;
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
        dataSource.open();
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

        User user = dataSource.getUser();


    }
}

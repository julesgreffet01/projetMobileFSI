package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class InfosActivity extends AppCompatActivity {

    private UserDataSource dataSource;
    private TextView textViewPrenom, textViewNom, textViewMail, textViewTel, textViewAdr;
    private Button btnAlternanceInfos, btnAccueilInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informations);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
        dataSource.open();
    }

    private void initialisation(){
        textViewPrenom = (TextView) findViewById(R.id.textViewPrenom);
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewMail = (TextView) findViewById(R.id.textViewMail);
        textViewTel = (TextView) findViewById(R.id.textViewTel);
        textViewAdr = (TextView) findViewById(R.id.textViewAdr);
        btnAlternanceInfos = (Button) findViewById(R.id.btnAlternanceInfos);
        btnAccueilInfos = (Button) findViewById(R.id.btnAccueilInfos);

        User user = dataSource.getUser();

        textViewPrenom.setText(user.getPrenomUti());
        textViewNom.setText(user.getNomUti());
        textViewMail.setText(user.getMailUti());
        textViewTel.setText(user.getTelUti());
        textViewAdr.setText(user.getAdresseUti());
        if("pas de maitre d'apprentissage".equals(user.getNomMA()) && "pas d'entreprise".equals(user.getNomEnt())){
            btnAlternanceInfos.setVisibility(View.GONE);
        } else {
            btnAlternanceInfos.setVisibility(View.VISIBLE);
        }
        btnAlternanceInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfosActivity.this, AlternanceActivity.class);
                startActivity(intent);
            }
        });
        btnAccueilInfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfosActivity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });
    }
}

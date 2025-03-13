package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bilan2Activity extends AppCompatActivity {

    private UserDataSource dataSource;
    private TextView textViewLibelleBil2, textViewSujMem, textViewBil2Date, textViewNoteBil2, textViewBil2Ora;
    private Button btnAccueilBil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bilan2);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
    }

    private void initialisation(){
        textViewBil2Date = (TextView) findViewById(R.id.textViewBil2Date);
        textViewLibelleBil2 = (TextView) findViewById(R.id.textViewLibelleBil2);
        textViewSujMem = (TextView) findViewById(R.id.textViewSujMem);
        textViewNoteBil2 = (TextView) findViewById(R.id.textViewNoteBil2);
        textViewBil2Ora = (TextView) findViewById(R.id.textViewBil2Ora);
        btnAccueilBil2 = (Button) findViewById(R.id.btnAccueilBil2);


        dataSource.open();
        User user = dataSource.getUser();
        dataSource.close();

        String date = user.getDateBil2();
        textViewBil2Date.setText(date);
        String lib = user.getLibBil2();
        textViewLibelleBil2.setText(lib);
        String suj = user.getSujMemoire();
        textViewSujMem.setText(suj);
        if(user.getNoteBil2() == 100){
            String note = "-";
            textViewNoteBil2.setText(note);
        } else {
            float note = user.getNoteBil2();
            textViewNoteBil2.setText(note+"");
        }
        if(user.getNoteOralBil2() == 100){
            String note = "-";
            textViewBil2Ora.setText(note);
        } else {
            float note = user.getNoteOralBil2();
            textViewBil2Ora.setText(note+"");
        }
        btnAccueilBil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bilan2Activity.this, AccueilActivity.class);
                startActivity(intent);
            }
        });

    }
}

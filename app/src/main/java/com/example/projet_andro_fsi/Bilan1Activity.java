package com.example.projet_andro_fsi;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bilan1Activity extends AppCompatActivity {

    private UserDataSource dataSource;

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

    }
}

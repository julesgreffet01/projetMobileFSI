package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModifActivity extends AppCompatActivity {

    private UserDataSource dataSource;
    private Button btnModifOk, btnModifCancel;
    private TextView editTextTel, editTextMail, editTextAdr, editTextCP, editTextVil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modif);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
        dataSource.open();
    }

    private void initialisation(){
        editTextTel = (TextView) findViewById(R.id.editTextTel);
        editTextMail = (TextView) findViewById(R.id.editTextMail);
        editTextAdr = (TextView) findViewById(R.id.editTextAdr);
        editTextCP = (TextView) findViewById(R.id.editTextCP);
        editTextVil = (TextView) findViewById(R.id.editTextVil);

        btnModifOk = (Button) findViewById(R.id.btnModifOk);
        btnModifCancel = (Button) findViewById(R.id.btnModifCancel);

        User user = dataSource.getUser();
        editTextTel.setText(user.getTelUti());
        editTextMail.setText(user.getMailUti());
        editTextAdr.setText(user.getAdresseUti());
        editTextCP.setText(user.getCpUti());
        editTextVil.setText(user.getVilUti());

        btnModifCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifActivity.this, InfosActivity.class);
                startActivity(intent);
            }
        });

        btnModifOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tel = editTextTel.getText().toString();
                String mail = editTextMail.getText().toString();
                String adr = editTextAdr.getText().toString();
                String cp = editTextCP.getText().toString();
                String vil = editTextVil.getText().toString();
                int id = user.getId();
                Call<Void> call = RetroFitClientUser.getInstance().getMyApi().modifUser(tel, mail, adr, cp, vil, id);
                call.enqueue(new Callback<Void>(){

                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        dataSource.applicModif(tel, mail, adr, cp, vil);
                        Intent intent = new Intent(ModifActivity.this, InfosActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Log.d("erreur", t.getMessage());
                        Toast.makeText(ModifActivity.this, "verifier votre connexion", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}

package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String login, mdp, error;
    private Button btnConnexion;
    private EditText editTextLog, editTextMdp;
    private UserDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initDB();
        initialisation();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
        dataSource.open();
        dataSource.clear();
    }
    private void initialisation(){
        editTextLog = (EditText) findViewById(R.id.editTextLogin);
        editTextMdp = (EditText) findViewById(R.id.editTextMdp);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);

        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login = editTextLog.getText().toString();
                mdp = editTextMdp.getText().toString();
                if (!login.isEmpty() && !mdp.isEmpty()) {
                    Call<ReponseAPI> call = RetroFitClientUser.getInstance().getMyApi().loginUser(login, mdp);
                    call.enqueue(new Callback<ReponseAPI>() {
                        @Override
                        public void onResponse(Call<ReponseAPI> call, Response<ReponseAPI> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                ReponseAPI reponse = response.body();

                                if ("success".equals(reponse.getStatus())) {
                                    User user = reponse.getUserData();
                                    if (user != null) {
                                        System.out.println(user.getLibBil1());
                                        dataSource.insert(user);
                                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                                        startActivity(intent);
                                    }
                                } else {
                                    String errorMessage = reponse.getErrorMessage();
                                    Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                System.out.println("Erreur HTTP : " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<ReponseAPI> call, Throwable t) {
                            System.out.println("Échec de la requête !");
                            Log.d("erreur", t.getMessage());
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Identifiant ou Mot de passe manquant", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
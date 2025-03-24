package com.example.projet_andro_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String login, mdp;
    private Button btnConnexion;
    private EditText editTextLog, editTextMdp;
    private UserDataSource dataSource;
    private CheckBox CBConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initDB();
        initialisation();
        verifConnexion();
    }

    private void initDB(){
        dataSource = new UserDataSource(this);
    }

    public void verifConnexion() {
        dataSource.open();
        User user = dataSource.getUser();
        if (user != null) {
            if (dataSource.verifConnected()) {
                Call<User> call = RetroFitClientUser.getInstance().getMyApi().updateUser(14518487, user.getId());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        if (user != null) {
                            dataSource.clear();
                            dataSource.insert(user);
                            dataSource.stayConnected();
                        }
                        dataSource.close();

                        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("erreur", t.getMessage());
                        Toast.makeText(MainActivity.this, "Vérifiez votre connexion", Toast.LENGTH_SHORT).show();
                        dataSource.close();
                    }
                });
            } else {
                dataSource.clear();
                dataSource.close();
            }
        } else {
            dataSource.close();
        }
    }

    private void initialisation(){
        editTextLog = (EditText) findViewById(R.id.editTextLogin);
        editTextMdp = (EditText) findViewById(R.id.editTextMdp);
        btnConnexion = (Button) findViewById(R.id.btnConnexion);
        CBConnected = (CheckBox) findViewById(R.id.CBConnected);

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
                                        dataSource.open();
                                        dataSource.insert(user);
                                        dataSource.close();
                                        if(CBConnected.isChecked()){
                                            dataSource.open();
                                            dataSource.stayConnected();
                                            dataSource.close();
                                        }
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
                            Toast.makeText(MainActivity.this, "verifier votre connexion", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    Toast.makeText(MainActivity.this, "Identifiant ou Mot de passe manquant", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
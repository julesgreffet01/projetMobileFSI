package com.example.projet_andro_fsi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientUser {
    private static RetroFitClientUser instance = null;
    private Api myApi;

    private RetroFitClientUser() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL) // Définit l'URL de base
                .addConverterFactory(GsonConverterFactory.create()) // Convertit JSON en objets Java et inversement
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static RetroFitClientUser getInstance() {
        if (instance == null) {
            instance = new RetroFitClientUser();
        }
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}

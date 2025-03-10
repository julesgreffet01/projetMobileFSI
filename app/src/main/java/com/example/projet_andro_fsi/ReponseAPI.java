package com.example.projet_andro_fsi;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

public class ReponseAPI {
    private String status;
    private Object data;

    public ReponseAPI(String status, Object data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public User getUserData() {
        if (data instanceof LinkedTreeMap) { // Retrofit stocke les objets JSON sous forme de LinkedTreeMap
            Gson gson = new Gson();
            String json = gson.toJson(data); // Convertit l'objet en String JSON
            return gson.fromJson(json, User.class); // Convertit en User
        }
        return null; // Retourne null si "data" n'est pas un objet
    }

    // ✅ Si "data" est une erreur sous forme de String, on la récupère
    public String getErrorMessage() {
        if (data instanceof String) {
            return (String) data;
        }
        return null;
    }
}

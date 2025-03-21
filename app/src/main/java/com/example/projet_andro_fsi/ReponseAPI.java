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
        if (data instanceof LinkedTreeMap) {
            Gson gson = new Gson();
            String json = gson.toJson(data);
            return gson.fromJson(json, User.class);
        }
        return null;
    }

    public String getErrorMessage() {
        if (data instanceof String) {
            return (String) data;
        }
        return null;
    }
}

package com.example.projet_andro_fsi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL = "https://olen-ort.fr/P2025/CABOTESN/Code/API/";

    @FormUrlEncoded
    @POST("jules.php")
    Call<ReponseAPI> loginUser(
            @Field("login") String login,
            @Field("mdp") String mdp
    );

    @FormUrlEncoded
    @POST("jules.php?modif")
    Call<Void> modifUser(
            @Field("tel") String tel,
            @Field("mail") String mail,
            @Field("adr") String adr,
            @Field("cp") String cp,
            @Field("vil") String vil,
            @Field("id") int id
    );
}
package com.example.projet_andro_fsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;
    public UserDataSource(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }
    public String info(){
        return dbHelper.TABLE_COMMENTS;
    }

    public void close(){
        dbHelper.close();
    }

    public void insert(User user){
        ContentValues valeur = new ContentValues();
        valeur.put("id", user.getId());
        valeur.put("nomUti", user.getNomUti());
        valeur.put("prenomUti", user.getPrenomUti());
        valeur.put("telUti", user.getTelUti());
        valeur.put("adresseUti", user.getAdresseUti());
        valeur.put("mailUti", user.getMailUti());
        valeur.put("nomMA", user.getNomMA());
        valeur.put("prenomMA", user.getPrenomMA());
        valeur.put("telMA", user.getTelMA());
        valeur.put("mailMA", user.getMailMA());
        valeur.put("nomEnt", user.getNomEnt());
        valeur.put("adresseEnt", user.getAdresseEnt());
        valeur.put("telEnt", user.getTelEnt());
        valeur.put("mailEnt", user.getMailEnt());
        valeur.put("libBil1", user.getLibBil1());
        valeur.put("notBil1", user.getNotBil1());
        valeur.put("remarqueBil1", user.getRemarqueBil1());
        valeur.put("noteEntBil1", user.getNoteEntBil1());
        valeur.put("noteOralBil1", user.getNoteOralBil1());
        valeur.put("dateBil1", user.getDateBil1());
        valeur.put("libBil2", user.getLibBil2());
        valeur.put("noteBil2", user.getNoteBil2());
        valeur.put("noteOralBil2", user.getNoteOralBil2());
        valeur.put("sujMemoire", user.getSujMemoire());
        valeur.put("dateBil2", user.getDateBil2());
        db.insert(MySQLiteHelper.TABLE_COMMENTS, null, valeur);
    }

    public void clear(){
        if(db != null){
            db.delete(MySQLiteHelper.TABLE_COMMENTS, null, null);
        }
    }
}

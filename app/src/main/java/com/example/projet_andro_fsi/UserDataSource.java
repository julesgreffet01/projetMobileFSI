package com.example.projet_andro_fsi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public User getUser() {
        User user = null;
        Cursor cursor = db.query(true, MySQLiteHelper.TABLE_COMMENTS,
                new String[]{
                        "id", "nomUti", "prenomUti", "telUti", "adresseUti", "mailUti",
                        "nomMA", "prenomMA", "telMA", "mailMA",
                        "nomEnt", "adresseEnt", "telEnt", "mailEnt",
                        "libBil1", "notBil1", "remarqueBil1", "noteEntBil1", "noteOralBil1", "dateBil1",
                        "libBil2", "noteBil2", "noteOralBil2", "sujMemoire", "dateBil2"
                },
                null, null, null, null, null, null);

        if (cursor.moveToFirst()) { // Vérifie s'il y a un résultat
            user = cursorToUser(cursor);
        }

        cursor.close();
        return user;
    }

    public User cursorToUser(Cursor curseur) {
        int id = curseur.getInt(0);
        String nomUti = curseur.getString(1);
        String prenomUti = curseur.getString(2);
        String telUti = curseur.getString(3);
        String adresseUti = curseur.getString(4);
        String mailUti = curseur.getString(5);
        String nomMA = curseur.getString(6);
        String prenomMA = curseur.getString(7);
        String telMA = curseur.getString(8);
        String mailMA = curseur.getString(9);
        String nomEnt = curseur.getString(10);
        String adresseEnt = curseur.getString(11);
        String telEnt = curseur.getString(12);
        String mailEnt = curseur.getString(13);
        String libBil1 = curseur.getString(14);
        float notBil1 = curseur.getFloat(15);
        String remarqueBil1 = curseur.getString(16);
        float noteEntBil1 = curseur.getFloat(17);
        float noteOralBil1 = curseur.getFloat(18);
        String dateBil1 = curseur.getString(19);
        String libBil2 = curseur.getString(20);
        float noteBil2 = curseur.getFloat(21);
        float noteOralBil2 = curseur.getFloat(22);
        String sujMemoire = curseur.getString(23);
        String dateBil2 = curseur.getString(24);

        return new User(id, nomUti, prenomUti, telUti, adresseUti, mailUti, nomMA, prenomMA, telMA, mailMA,
                nomEnt, adresseEnt, telEnt, mailEnt, libBil1, notBil1, remarqueBil1, noteEntBil1,
                noteOralBil1, dateBil1, libBil2, noteBil2, noteOralBil2, sujMemoire, dateBil2);
    }

    public void clear(){
        if(db != null){
            db.delete(MySQLiteHelper.TABLE_COMMENTS, null, null);
        }
    }
}

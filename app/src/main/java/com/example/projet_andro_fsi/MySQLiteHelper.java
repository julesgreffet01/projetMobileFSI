package com.example.projet_andro_fsi;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "User";
    private static final String DATABASE_NAME = "fsiMobile.db";
    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_CREATE = "CREATE TABLE IF NOT EXISTS " + TABLE_COMMENTS + " (" +
            "id integer primary key, " +
            "nomUti text, prenomUti text, telUti text, adresseUti text, " +
            "mailUti text, nomMA text, prenomMA text, telMA text, mailMA text, " +  // 10
            "nomEnt text, adresseEnt text, telEnt text, mailEnt text, libBil1 text, " +
            "notBil1 text, remarqueBil1 text, noteEntBil1 integer, noteOralBil1 integer, dateBil1 text, " +
            "libBil2 text, noteBil2 integer, noteOralBil2 integer, sujMemoire text, dateBil2 integer, " +
            "cp text, vil text, connected integer DEFAULT 0);";

    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }
}

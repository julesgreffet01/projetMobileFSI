package com.example.projet_andro_fsi;

import java.util.Date;

public class User {
    private int id;
    private String nomUti;
    private String prenomUti;
    private String telUti;
    private String adresseUti;
    private String mailUti;
    private String nomMA;
    private String prenomMA;
    private String telMA;
    private String mailMA;
    private String nomEnt;
    private String adresseEnt;
    private String telEnt;
    private String mailEnt;
    private String libBil1;
    private float notBil1;
    private String remarqueBil1;
    private float noteEntBil1;
    private float noteOralBil1;
    private String dateBil1;
    private String libBil2;
    private float noteBil2;
    private float noteOralBil2;
    private String sujMemoire;
    private String dateBil2;

    public User(int id, String nomUti, String prenomUti, String telUti, String adresseUti, String mailUti, String nomMA, String prenomMA, String telMA, String mailMA, String nomEnt, String adresseEnt, String telEnt, String mailEnt, String libBil1, float notBil1, String remarqueBil1, float noteEntBil1, float noteOralBil1, String dateBil1, String libBil2, float noteBil2, float noteOralBil2, String sujMemoire, String dateBil2) {
        this.id = id;
        this.nomUti = nomUti;
        this.prenomUti = prenomUti;
        this.telUti = telUti;
        this.adresseUti = adresseUti;
        this.mailUti = mailUti;
        this.nomMA = nomMA;
        this.prenomMA = prenomMA;
        this.telMA = telMA;
        this.mailMA = mailMA;
        this.nomEnt = nomEnt;
        this.adresseEnt = adresseEnt;
        this.telEnt = telEnt;
        this.mailEnt = mailEnt;
        this.libBil1 = libBil1;
        this.notBil1 = notBil1;
        this.remarqueBil1 = remarqueBil1;
        this.noteEntBil1 = noteEntBil1;
        this.noteOralBil1 = noteOralBil1;
        this.dateBil1 = dateBil1;
        this.libBil2 = libBil2;
        this.noteBil2 = noteBil2;
        this.noteOralBil2 = noteOralBil2;
        this.sujMemoire = sujMemoire;
        this.dateBil2 = dateBil2;
    }

    public int getId() {
        return id;
    }

    public String getNomUti() {
        return nomUti;
    }

    public String getPrenomUti() {
        return prenomUti;
    }

    public String getTelUti() {
        return telUti;
    }

    public String getAdresseUti() {
        return adresseUti;
    }

    public String getMailUti() {
        return mailUti;
    }

    public String getNomMA() {
        return nomMA;
    }

    public String getPrenomMA() {
        return prenomMA;
    }

    public String getTelMA() {
        return telMA;
    }

    public String getMailMA() {
        return mailMA;
    }

    public String getNomEnt() {
        return nomEnt;
    }

    public String getAdresseEnt() {
        return adresseEnt;
    }

    public String getTelEnt() {
        return telEnt;
    }

    public String getMailEnt() {
        return mailEnt;
    }

    public String getLibBil1() {
        return libBil1;
    }

    public float getNotBil1() {
        return notBil1;
    }

    public String getRemarqueBil1() {
        return remarqueBil1;
    }

    public float getNoteEntBil1() {
        return noteEntBil1;
    }

    public float getNoteOralBil1() {
        return noteOralBil1;
    }

    public String getDateBil1() {
        return dateBil1;
    }

    public String getLibBil2() {
        return libBil2;
    }

    public float getNoteBil2() {
        return noteBil2;
    }

    public float getNoteOralBil2() {
        return noteOralBil2;
    }

    public String getSujMemoire() {
        return sujMemoire;
    }

    public String getDateBil2() {
        return dateBil2;
    }
}

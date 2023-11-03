package com.example.demo.bean;

public class Usuari {

    private int id;
    private String nom;
    private String cognom;
    private enum Tipus {ADMIN, ALUMNE, EMPRESA};
    private Tipus tipusUsuari;

    public Usuari(int id, String nom, String cognom, Tipus tipus) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.tipusUsuari = tipus;
    }

    public Usuari() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public Tipus getTipusUsuari() {
        return tipusUsuari;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setTipusUsuari(Tipus tipusUsuari) {
        this.tipusUsuari = tipusUsuari;
    }

    @Override
    public String toString() {
        return "Usuari{" + "id=" + id + ", nom=" + nom + ", cognom=" + cognom + ", tipusUsuari=" + tipusUsuari + '}';
    }
}

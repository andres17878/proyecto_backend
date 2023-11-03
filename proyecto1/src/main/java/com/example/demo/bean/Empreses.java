package com.example.demo.bean;

public class Empreses {
    private int id;
    private String nom;
    private String direccio;
    private String telefon;

    public Empreses(int id, String nom, String direccio, String telefon) {
        this.id = id;
        this.nom = nom;
        this.direccio = direccio;
        this.telefon = telefon;
    }

    public Empreses() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDireccio() {
        return direccio;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public void setNom(String nom) {
        this.nom = nom;
    }   

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }   

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Empreses{" + "id=" + id + ", nom=" + nom + ", direccio=" + direccio + ", telefon=" + telefon + '}';
    }
    

}

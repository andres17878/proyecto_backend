package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Usuari {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String cognom;

    @Column(nullable = false, unique = true)
    private String tipusUsuari;

    public Usuari() {
    }

    public Usuari(Long id, String nom, String cognom, String tipusUsuari) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.tipusUsuari = tipusUsuari;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getTipusUsuari() {
        return tipusUsuari;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setTipusUsuari(String tipusUsuari) {
        this.tipusUsuari = tipusUsuari;
    }
}


    

    
    
    


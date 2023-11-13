package com.example.demo.model;

import org.hibernate.mapping.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String descripcio;

    @Column
    private String ofertes;

    

    public Empresa() {
    }

    public Empresa(Long id, String nom, String descripcio, String ofertes) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.ofertes = ofertes;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getOfertes() {
        return ofertes;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public void setNom(String nom) {
        this.nom = nom;
    }   

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setOfertes(String ofertes) {
        this.ofertes = ofertes;
    }
    
}

package com.example.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Empresa {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String descripcio;

    @OneToOne
    @JoinColumn(name="oferta_id")
    private Oferta oferta;

    public Empresa() {
    }

    public Empresa(Long id, String nom, String descripcio) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
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

    public void setId(Long id) {
        this.id = id;
    }   

    public void setNom(String nom) {
        this.nom = nom;
    }   

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
}

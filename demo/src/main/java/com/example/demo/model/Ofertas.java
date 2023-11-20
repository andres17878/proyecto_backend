package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ofertas {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nom;

    @Column
    private String descripcio;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Empresa empresa;

    public Ofertas() {
    }

    public Ofertas(Long id, String nom, String descripcio, Empresa empresa) {
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.empresa = empresa;
    }

    public Ofertas(String nom, String descripcio, Empresa empresa) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.empresa = empresa;
    }

    public Ofertas(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ofertas )) return false;
        return id != null && id.equals(((Ofertas) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }




}

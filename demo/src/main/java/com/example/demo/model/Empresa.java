package com.example.demo.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nom" , nullable = false)
    private String nom;

    @Column (name = "descripcio" , nullable = false)
    private String descripcio;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Ofertas> ofertas;

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

    public List<Ofertas> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Ofertas> ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa )) return false;
        return id != null && id.equals(((Empresa) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}

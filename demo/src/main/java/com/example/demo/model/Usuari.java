package com.example.demo.model;

public class Usuari {
    
    private Long id;
    private enum tipus { ADMIN, ALUMNE }

    private tipus tipus;
    

    public Usuari() {
    }

    public Usuari(Long id, tipus tipus) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id no pot ser null");
        }
        this.id = id;
    }

    public tipus getTipus() {
        return tipus;
    }

    public void setTipus(tipus tipus) {
        this.tipus = tipus;
    }

}

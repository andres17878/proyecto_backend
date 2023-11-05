package com.example.demo.model;

import org.springframework.data.annotation.Id;


public record Usuari (@Id Integer id, String nom, String cognom, TipusUsuari tipusUsuari) {
}


    

    
    
    


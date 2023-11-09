package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuari;
import com.example.demo.repository.Borsa;

@RestController
@RequestMapping("/")
public class BorsaController {

    @Autowired
    private final Borsa borsa;

   
    public BorsaController(Borsa borsa) {
        this.borsa = borsa;
    }

    @GetMapping("/usuaris")
    public Iterable<Usuari> getBorsa() {
        return borsa.findAll();
    }

    /* 
    @GetMapping("/usuaris/consultar_empresas")

    POR HACER: ANDRÉS
    public Iterable<Usuari> getEmpresas(){
        return "Por Hacer";
        
    }

    @GetMapping("/usuaris/afegir_empresas")
    POR HACER: ANDRÉS


    @GetMapping("/usuaris/modificar_empresas")
    POR HACER: ANXO


    @GetMapping("usuaris/eliminar_empresas")
    POR HACER: ERIC
    */
}

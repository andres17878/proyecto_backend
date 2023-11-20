package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;
import com.example.demo.repository.Borsa;
import com.example.demo.repository.OfertasRepository;

@RestController
@RequestMapping("/")
public class BorsaController {

    @Autowired
    private final Borsa borsa;

    @Autowired
    private final OfertasRepository ofertasRepository;

    
   
    public BorsaController(Borsa borsa, OfertasRepository ofertasRepository) {
        this.borsa = borsa;
        this.ofertasRepository = ofertasRepository;
    }
    
    @GetMapping("/consultar_empresas")
    public Iterable<Empresa> getEmpresas(){
        return borsa.findAll();
    }

    

    @GetMapping("/afegir_empresa")
    public void addEmpresa(Empresa empresa){
        borsa.save(empresa);
    }

     
    @PutMapping("/modificar_empresas/{id}")
    public void updateEmpresa(@PathVariable Long id, @RequestBody Empresa newEmpresa){
        borsa.findById(id).map(empresa -> {
            empresa.setNom(newEmpresa.getNom());
            empresa.setDescripcio(newEmpresa.getDescripcio());
            return borsa.save(empresa);
        });
    }

    
        
    @DeleteMapping("/eliminar_empresa/{id}")
    public void deleteEmpresa(@PathVariable Long id){
        borsa.deleteById(id);
    }

    @GetMapping("/afegir_oferta")
    public void addOferta(Ofertas oferta){
        ofertasRepository.save(oferta);
    }
    
    
    @GetMapping("/consultar_ofertas")
    public Iterable<Ofertas> getOfertas(){
        return ofertasRepository.findAll();
    }

    @GetMapping("/consultar_ofertas/{id}")
    public Optional<Ofertas> getOferta(@PathVariable Long id){
        return ofertasRepository.findById(id);
    }

    @PutMapping("/modificar_ofertas/{id}")
    public void updateOferta(@PathVariable Long id, @RequestBody Ofertas newOferta){
        ofertasRepository.findById(id).map(oferta -> {
            oferta.setNom(newOferta.getNom());
            oferta.setDescripcio(newOferta.getDescripcio());
            return ofertasRepository.save(oferta);
        });
    }

    @DeleteMapping("/eliminar_oferta/{id}")
    public void deleteOferta(@PathVariable Long id){
        ofertasRepository.deleteById(id);
    }
}

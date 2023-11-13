package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empresa;
import com.example.demo.repository.Borsa;

@RestController
@RequestMapping("/")
public class BorsaController {

    @Autowired
    private final Borsa borsa;

   
    public BorsaController(Borsa borsa) {
        this.borsa = borsa;
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
            empresa.setOfertes(newEmpresa.getOfertes());
            return borsa.save(empresa);
        });
    }

    
        
    @DeleteMapping("/eliminar_empresa/{id}")
    public void deleteEmpresa(@PathVariable Long id){
        borsa.deleteById(id);
    }
    
}

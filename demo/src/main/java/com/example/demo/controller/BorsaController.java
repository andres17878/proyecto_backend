package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;
import com.example.demo.service.BorsaServiceImpl;

@RestController
@RequestMapping("/")
public class BorsaController {

    private BorsaServiceImpl borsaServiceImpl;

    public BorsaController(BorsaServiceImpl borsaService) {
        this.borsaServiceImpl = borsaService;
    }


    // Rutas para Empresa

    @GetMapping("/consultar_empresas")
    public List<Empresa> findAllEmpresas(){
        return borsaServiceImpl.findAllEmpresas();
    }

    @GetMapping("/consultar_empresas/{id}")
    public Optional <Empresa> findById(@PathVariable Long id){
        return borsaServiceImpl.findById(id);
    }

    @PostMapping("/afegir_empresa")
    public void addEmpresa(@RequestBody Empresa empresa){
        borsaServiceImpl.addEmpresa(empresa);
    }
    
    @PutMapping("/modificar_empresa/{id}")
    public void updateEmpresa(@PathVariable Long id, @RequestBody Empresa newEmpresa){
        borsaServiceImpl.updateEmpresa(id, newEmpresa);
    }

    @DeleteMapping("/eliminar_empresa/{id}")
    public void deleteEmpresa(@PathVariable Long id){
        borsaServiceImpl.deleteEmpresa(id);
    }

    // Rutas para Ofertas

    @PostMapping("/afegir_oferta")
    public void addOferta(@RequestBody Ofertas oferta){
        borsaServiceImpl.addOfertas(oferta);
    }
    
    
    @GetMapping("/consultar_ofertas")
    public Iterable<Ofertas> getOfertas(){
        return borsaServiceImpl.findAllOfertas();
    }
    

    @GetMapping("/consultar_ofertas/{id}")
    public Optional<Ofertas> getOferta(@PathVariable Long id){
        return borsaServiceImpl.findByIdOfertas(id);
    }
    

    @PutMapping("/modificar_ofertas/{id}")
    public void updateOferta(@PathVariable Long id, @RequestBody Ofertas newOferta){
        borsaServiceImpl.updateOfertas(id, newOferta);
    }
    

    @DeleteMapping("/eliminar_oferta/{id}")
    public void deleteOferta(@PathVariable Long id){
        borsaServiceImpl.deleteOfertas(id);
    }
    
}

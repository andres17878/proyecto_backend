package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;

public interface BorsaService {

    // Servicios para Empresa
    List <Empresa> findAllEmpresas();
    Optional <Empresa> findById(Long id);
    void addEmpresa(Empresa empresa);
    void updateEmpresa(Long id, Empresa newEmpresa);
    void deleteEmpresa(Long id);

    // Servicios para Ofertas
    List <Ofertas> findAllOfertas();
    Optional <Ofertas> findByIdOfertas(Long id);
    void addOfertas(Ofertas oferta);
    void updateOfertas(Long id, Ofertas newOferta);
    void deleteOfertas(Long id);


}

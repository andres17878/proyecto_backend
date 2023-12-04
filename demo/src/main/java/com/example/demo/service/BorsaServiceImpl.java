package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.OfertasRepository;

@Service
public class BorsaServiceImpl implements BorsaService {
    
    private EmpresaRepository empresaRepository;
    private OfertasRepository ofertasRepository;

    public BorsaServiceImpl(EmpresaRepository empresaRepository, OfertasRepository ofertasRepository) {
        this.empresaRepository = empresaRepository;
        this.ofertasRepository = ofertasRepository;
    }
    
    // Servicios implementados para Empresa
    @Override
    public List <Empresa> findAllEmpresas() {
        return (List<Empresa>) empresaRepository.findAll();
    }

    @Override
    public Optional <Empresa> findById(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public void addEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

    @Override
    public void updateEmpresa(Long id, Empresa newEmpresa) {
        empresaRepository.findById(id).map(empresa -> {
            empresa.setNom(newEmpresa.getNom());
            empresa.setDescripcio(newEmpresa.getDescripcio());
            return empresaRepository.save(empresa);
        });
    }

    @Override
    public void deleteEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }


    // Servicios implementados para Ofertas
    @Override
    public List <Ofertas> findAllOfertas() {
        return ofertasRepository.findAll();
    }

    @Override
    public Optional <Ofertas> findByIdOfertas(Long id) {
        return ofertasRepository.findById(id);
    }

    @Override
    public void addOfertas(Ofertas oferta) {
        ofertasRepository.save(oferta);
    }

    @Override
    public void updateOfertas(Long id, Ofertas newOferta) {
        ofertasRepository.findById(id).map(oferta -> {
            oferta.setNom(newOferta.getNom());
            oferta.setDescripcio(newOferta.getDescripcio());
            return ofertasRepository.save(oferta);
        });
    }

    @Override
    public void deleteOfertas(Long id) {
        ofertasRepository.deleteById(id);
    }
    

    
}

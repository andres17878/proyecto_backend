package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;
import com.example.demo.repository.OfertasRepository;

@DataJpaTest
public class OfertasRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OfertasRepository ofertasRepository;

    private Empresa insertDemoEmpresa(){
        Empresa empresa = new Empresa(null, "Empresa de prova", "Això és una empresa de prova");
        entityManager.persist(empresa);
        entityManager.flush();
        return empresa;
    }

    private Ofertas insertDemoOferta(){
        Empresa empresa = insertDemoEmpresa();
        Ofertas oferta = new Ofertas(null, "Oferta de prova", "Això és una oferta de prova", empresa);
        entityManager.persist(oferta);
        entityManager.flush();
        return oferta;
    }

    @Test
    void findAll() {
        insertDemoOferta();
        Iterable <Ofertas> ofertas = ofertasRepository.findAll();
        assert(ofertas.iterator().hasNext());
    }

    @Test
    void addOferta(){
        Ofertas oferta = insertDemoOferta();
        ofertasRepository.save(oferta);
        assert(ofertasRepository.findById(oferta.getId()).isPresent());
    }

    @Test
    void consultarOfertaById(){
        Ofertas oferta = insertDemoOferta();
        Long id = oferta.getId();
        assert(ofertasRepository.findById(id).isPresent());
    }

    @Test
    void updateOfertaById(){
        Ofertas oferta = insertDemoOferta();
        Long id = oferta.getId();
        oferta.setDescripcio("Això és una oferta de prova modificada");
        ofertasRepository.save(oferta);
        assert(ofertasRepository.findById(id).get().getDescripcio().equals("Això és una oferta de prova modificada"));
    }

    @Test
    void eliminaOfertaById(){
        Ofertas oferta = insertDemoOferta();
        Long id = oferta.getId();
        ofertasRepository.deleteById(id);
        assert(!ofertasRepository.findById(id).isPresent());
    } 
}

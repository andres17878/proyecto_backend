package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.Empresa;
import com.example.demo.repository.EmpresaRepository;

@DataJpaTest
public class EmpresaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmpresaRepository empresaRepo;

    // Cuando se llama a este método se inserta una empresa en la base de datos
    private Empresa insertDemoEmpresa(){
        Empresa empresa = new Empresa(null, "Empresa de prova", "Això és una empresa de prova");
        entityManager.persist(empresa);
        entityManager.flush();
        return empresa;
    }

    // El test comprueba que hayan 1 o más empresas porque hay un import de 3 empresas en resources/import.sql
    @Test
    void findAll() {
        insertDemoEmpresa();
        Iterable <Empresa> empresas = empresaRepo.findAll();
        assert(empresas.iterator().hasNext());
    }

    // Este test comprueba que se añada una empresa a la base de datos
    @Test
    void addEmpresa() {
        Empresa empresa = insertDemoEmpresa();
        empresaRepo.save(empresa);
        assert(empresaRepo.findById(empresa.getId()).isPresent());
    }

    // En este test se introduce una empresa, se modifica y se comprueba que se ha modificado
    @Test 
    void updateEmpresa(){
        Empresa empresa = insertDemoEmpresa();
        empresa.setNom("Empresa de prova modificada");
        empresaRepo.save(empresa);
        assert(empresaRepo.findById(empresa.getId()).get().getNom().equals("Empresa de prova modificada"));
    }

    // En este test se introduce una empresa, se elimina y se comprueba que no existe
    @Test
    void deleteEmpresa(){
        Empresa empresa = insertDemoEmpresa();
        empresaRepo.delete(empresa);
        assert(!empresaRepo.findById(empresa.getId()).isPresent());
    }

}
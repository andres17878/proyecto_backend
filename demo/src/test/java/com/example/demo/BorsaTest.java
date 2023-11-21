package com.example.demo;


import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.Empresa;
import com.example.demo.repository.Borsa;

@DataJpaTest
public class BorsaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private Borsa borsa;

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
        Iterable <Empresa> empresas = borsa.findAll();
        ArrayList <Empresa> empresasList = new ArrayList <Empresa> ();
        empresas.forEach(empresasList::add);
        System.out.println(empresasList.size());
        assert(empresasList.size() >= 1);
    }
}
package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Empresa;
import com.example.demo.model.Ofertas;
import com.example.demo.repository.EmpresaRepository;
import com.example.demo.repository.OfertasRepository;

public class BorsaServiceImplTest {

    BorsaService borsaService;

    @Mock
    EmpresaRepository empresaRepository;

    @Mock
    OfertasRepository ofertasRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        borsaService = new BorsaServiceImpl(empresaRepository, ofertasRepository);
    }
    
    @Test
    void findAllEmpresas() {

        when(empresaRepository.findAll()).thenReturn(List.of());
        List <Empresa> empresas = borsaService.findAllEmpresas();

        //Junit
        assertNotNull(empresas);
        assertEquals(0, empresas.size());

        // Mockito
        verify(empresaRepository, times(1)).findAll();

    }

    @Test
    void findEmpresasById() {
        when(empresaRepository.findById(1L)).thenReturn(Optional.of(new Empresa()));
        Optional <Empresa> empresa = borsaService.findById(1L);

        //Junit
        assertNotNull(empresa);
        assertTrue(empresa.isPresent());
        empresa.get().setId(1L);
        assertEquals(1L, empresa.get().getId());

        // Mockito
        verify(empresaRepository, times(1)).findById(1L);
    }

    @Test
    void addEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNom("Empresa 1");
        empresa.setDescripcio("Descripcio 1");

        borsaService.addEmpresa(empresa);

        // Mockito
        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    void updateEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setNom("Empresa 1");
        empresa.setDescripcio("Descripcio 1");

        when(empresaRepository.findById(1L)).thenReturn(Optional.of(empresa));
        when(empresaRepository.save(empresa)).thenReturn(empresa);

        borsaService.updateEmpresa(1L, empresa);

        // Mockito
        verify(empresaRepository, times(1)).findById(1L);
        verify(empresaRepository, times(1)).save(empresa);
    }

    @Test
    void deleteEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setId(1L);
        empresa.setNom("Empresa 1");
        empresa.setDescripcio("Descripcio 1");

        when(empresaRepository.findById(1L)).thenReturn(Optional.of(empresa));

        borsaService.deleteEmpresa(1L);

        // Mockito
        verify(empresaRepository, times(1)).deleteById(1L);
    }

    // Tests mockito para los servicios de Ofertas

    @Test
    void findAllOfertas() {

        when(ofertasRepository.findAll()).thenReturn(List.of());
        List<Ofertas> ofertas = borsaService.findAllOfertas();

        //Junit
        assertNotNull(ofertas);
        assertEquals(0, ofertas.size());

        // Mockito
        verify(ofertasRepository, times(1)).findAll();

    }

    @Test
    void findByIdOfertas() {
        when(ofertasRepository.findById(1L)).thenReturn(Optional.of(new Ofertas()));
        Optional <Ofertas> oferta = borsaService.findByIdOfertas(1L);

        //Junit
        assertNotNull(oferta);
        assertTrue(oferta.isPresent());
        oferta.get().setId(1L);
        assertEquals(1L, oferta.get().getId());

        // Mockito
        verify(ofertasRepository, times(1)).findById(1L);
    }

    @Test
    void addOfertas() {
        Ofertas oferta = new Ofertas();
        oferta.setNom("Oferta 1");
        oferta.setDescripcio("Descripcio 1");

        borsaService.addOfertas(oferta);

        // Mockito
        verify(ofertasRepository, times(1)).save(oferta);
    }

    @Test
    void updateOfertas() {
        Ofertas oferta = new Ofertas();
        oferta.setId(1L);
        oferta.setNom("Oferta 1");
        oferta.setDescripcio("Descripcio 1");

        when(ofertasRepository.findById(1L)).thenReturn(Optional.of(oferta));
        when(ofertasRepository.save(oferta)).thenReturn(oferta);

        borsaService.updateOfertas(1L, oferta);

        // Mockito
        verify(ofertasRepository, times(1)).findById(1L);
        verify(ofertasRepository, times(1)).save(oferta);
    }

    @Test
    void deleteOfertas() {
        Ofertas oferta = new Ofertas();
        oferta.setId(1L);
        oferta.setNom("Oferta 1");
        oferta.setDescripcio("Descripcio 1");

        when(ofertasRepository.findById(1L)).thenReturn(Optional.of(oferta));

        borsaService.deleteOfertas(1L);

        // Mockito
        verify(ofertasRepository, times(1)).deleteById(1L);
    }
}

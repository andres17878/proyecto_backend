package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ofertas;

@Repository
public interface OfertasRepository extends CrudRepository<Ofertas,Long> {
    
}

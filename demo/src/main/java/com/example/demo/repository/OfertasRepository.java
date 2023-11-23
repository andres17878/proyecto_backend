package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ofertas;

@Repository
public interface OfertasRepository extends JpaRepository<Ofertas,Long> {
    
}

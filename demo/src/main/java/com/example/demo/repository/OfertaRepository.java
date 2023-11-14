package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Oferta;

@Repository
public interface OfertaRepository extends CrudRepository<Oferta,Long> {
}

package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuari;

@Repository
public interface Borsa extends CrudRepository<Usuari,Long> {
}
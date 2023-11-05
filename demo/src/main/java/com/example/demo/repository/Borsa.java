package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.Usuari;

@Component
public interface Borsa extends CrudRepository<Usuari,Integer> {
}
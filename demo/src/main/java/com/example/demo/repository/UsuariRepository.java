package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Usuari;

import java.util.Optional;

@Repository
public interface UsuariRepository extends JpaRepository<Usuari, Long> {

    Optional<Usuari> findByUsername(String username);
}

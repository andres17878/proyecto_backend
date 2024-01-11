package com.example.demo.service;

import com.example.demo.dto.UserRegisterDTO;
import com.example.demo.model.UsuariAuthority;
import com.example.demo.model.Usuari;
import com.example.demo.repository.UsuariRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityService {

    private final UsuariRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserEntityService(UsuariRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Usuari> findByUsername(String username) {
        return this.repository.findByUsername(username);
    }

    public Usuari save(UserRegisterDTO userDTO) {
        Usuari user = new Usuari(
                null,
                userDTO.username(),
                passwordEncoder.encode(userDTO.password()),
                userDTO.email(),
                List.of(UsuariAuthority.READ)
        );
        return this.repository.save(user);
    }

}
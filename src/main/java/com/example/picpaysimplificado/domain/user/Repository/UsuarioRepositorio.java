package com.example.picpaysimplificado.domain.user.Repository;

import com.example.picpaysimplificado.domain.user.User.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findUsuarioByCPF(String CPF);

    Optional<Usuario> findUsuarioById(Long id);
}


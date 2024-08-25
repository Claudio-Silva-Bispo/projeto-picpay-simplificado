package com.example.picpaysimplificado.domain.user.Repositorio;

import com.example.picpaysimplificado.domain.user.Transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {
}

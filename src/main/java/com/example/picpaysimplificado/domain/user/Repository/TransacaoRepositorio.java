package com.example.picpaysimplificado.domain.user.Repository;

import com.example.picpaysimplificado.domain.user.Transaction.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {
}

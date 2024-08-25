package com.example.picpaysimplificado.domain.user.Transaction;

import com.example.picpaysimplificado.domain.user.User.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transacoes")
@Table(name = "transacoes")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor

public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "enviar_id")
    private Usuario enviar;

    @ManyToOne
    @JoinColumn(name = "receber_id")
    private Usuario receber;

    private LocalDateTime timestamp;



}

package com.example.picpaysimplificado.domain.user.Transaction;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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

    private BigDecimal conta;



}

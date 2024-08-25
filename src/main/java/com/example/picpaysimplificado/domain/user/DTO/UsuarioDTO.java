package com.example.picpaysimplificado.domain.user.DTO;

import com.example.picpaysimplificado.domain.user.User.UsuarioTipo;

import java.math.BigDecimal;

public record UsuarioDTO(String nome, String CPF, BigDecimal extrato, String email, String senha, UsuarioTipo usuarioTipo) {
}

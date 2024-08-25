package com.example.picpaysimplificado.domain.user.DTO;

import java.math.BigDecimal;

public record TransacaoDTO(BigDecimal valor, Long enviarId, Long receberId) {


}

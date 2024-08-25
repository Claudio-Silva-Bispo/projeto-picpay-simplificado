package com.example.picpaysimplificado.domain.user.Service;

import com.example.picpaysimplificado.domain.user.Repository.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacaoRepositorio repositorio;

    // Método para criar uma transação
    public void criarTransacao(TransacaoDTO){
        return;
    }
}

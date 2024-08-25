package com.example.picpaysimplificado.domain.user.Service;

import com.example.picpaysimplificado.domain.user.DTO.TransacaoDTO;
import com.example.picpaysimplificado.domain.user.Repository.TransacaoRepositorio;
import com.example.picpaysimplificado.domain.user.Transaction.Transacao;
import com.example.picpaysimplificado.domain.user.User.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransacaoService {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransacaoRepositorio repositorio;

    private final RestTemplate restTemplate;

    // Inicializando RestTemplate no construtor
    public TransacaoService() {
        this.restTemplate = new RestTemplate();
    }

    // Método para criar uma transação
    public void criarTransacao(TransacaoDTO transacao) throws Exception {
        Usuario enviar = this.usuarioService.findUsuarioById(transacao.enviarId());
        Usuario receber = this.usuarioService.findUsuarioById(transacao.receberId());

        // validações
        usuarioService.validacaoTransacao(enviar, transacao.valor());

        // Saber se a transação está autorizado para realizar a transferência
        boolean isAutorizado = this.autorizacaoTransacao(enviar, transacao.valor());
        if (!isAutorizado){
            throw new Exception("Transação não autorizada");
        }

        Transacao novatransacao = new Transacao();
        novatransacao.setSaldo(transacao.valor());
        novatransacao.setEnviar(enviar);
        novatransacao.setReceber(receber);
        novatransacao.setTimestamp(LocalDateTime.now());

        // Atualizar o saldo dos usuários
        enviar.setExtrato(enviar.getExtrato().subtract(transacao.valor()));
        receber.setExtrato(receber.getExtrato().add(transacao.valor()));

        // persistir os dados no banco de dados
        this.repositorio.save(novatransacao);
        this.usuarioService.salveUser(enviar);
        this.usuarioService.salveUser(receber);

    }

    public boolean autorizacaoTransacao(Usuario enviar, BigDecimal valor){
        String url;
        ResponseEntity<Map> autorizacaoResposta = restTemplate.getForEntity( url = "https://util.devi.tools/api/v2/authorize", Map.class);

    if (autorizacaoResposta.getStatusCode() == HttpStatus.OK){
        String mensagem = (String) autorizacaoResposta.getBody().get("mensagem");
        return "Autorizado".equalsIgnoreCase(mensagem);
    }else return false;

    }
}

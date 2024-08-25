package com.example.picpaysimplificado.domain.user.Service;

import com.example.picpaysimplificado.domain.user.DTO.NotificacaoDTO;
import com.example.picpaysimplificado.domain.user.User.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificacaoService {

    @Autowired
    private RestTemplate restTemplate;

    public void enviarNotificacao(Usuario usuario, String mensagem) throws Exception {

        String email = usuario.getEmail();
        String url = "https://util.devi.tools/api/v1/notify";
        NotificacaoDTO solicitacaoNotificacao = new NotificacaoDTO(email, mensagem);

        ResponseEntity<String> response = restTemplate.postForEntity(url, solicitacaoNotificacao, String.class);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Falha ao enviar a notificação.");
        } else {
            System.out.println("Notificação enviada com sucesso.");
        }
    }
}

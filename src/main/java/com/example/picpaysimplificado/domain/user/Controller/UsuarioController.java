package com.example.picpaysimplificado.domain.user.Controller;

import com.example.picpaysimplificado.domain.user.DTO.UsuarioDTO;
import com.example.picpaysimplificado.domain.user.Service.UsuarioService;
import com.example.picpaysimplificado.domain.user.User.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Para enviar dados
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(UsuarioDTO usuarioDTO){
        Usuario novoUsuario = usuarioService.criarUsuario(usuarioDTO);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    // Listar os usuários criados
    @GetMapping
    public ResponseEntity<List<Usuario>> pegarTodosUsuarios(){
        List<Usuario> usuarios =  this.usuarioService.pegarTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}

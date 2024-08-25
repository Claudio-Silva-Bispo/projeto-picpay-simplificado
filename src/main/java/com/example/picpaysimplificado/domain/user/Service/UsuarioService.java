package com.example.picpaysimplificado.domain.user.Service;

import com.example.picpaysimplificado.domain.user.DTO.UsuarioDTO;
import com.example.picpaysimplificado.domain.user.Repository.UsuarioRepositorio;
import com.example.picpaysimplificado.domain.user.User.Usuario;
import com.example.picpaysimplificado.domain.user.User.UsuarioTipo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

// Indicar para o Spring que é uma classe de serviço
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepositorio repositorio;

    public void validacaoTransacao(Usuario sender, BigDecimal valor) throws Exception {
        if (sender.getUserType() == UsuarioTipo.MERCHANT){
            throw new Exception("Usuario do tipo Lojista não está autorizado a realizar transação");
        }

        if (sender.getExtrato().compareTo(valor) < 0){
            throw new Exception("Saldo insuficiente");
        }
    }

    // método para que minha classe não use o repository toda vez, vai usar esse método. Uso no banco de dados.
    public Usuario findUsuarioById(Long id) throws Exception {
        return this.repositorio.findUsuarioById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    // Salvar um novo usuario no banco de dados
    public void salveUser(Usuario usuario){
        this.repositorio.save(usuario);
    }

    // Criar usuário
    public Usuario criarUsuario(UsuarioDTO data){
        Usuario novoUsuario = new Usuario(data);
        this.salveUser(novoUsuario);
        return novoUsuario;
    }

    // Coletar todos os usuários
    public List<Usuario> pegarTodosUsuarios(){
       return this.repositorio.findAll();
    }
}

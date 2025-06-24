//Responsável pela lógica de negócios relacionada aos usuários do sistema.
package com.afm.trabalho_ps.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afm.trabalho_ps.model.Usuario;
import com.afm.trabalho_ps.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    // CREATE (C)
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // READ (R)
    public Optional<Usuario> buscar(Long id) {
        return usuarioRepository.findById(id);
    }

    public Iterable<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    // UPDATE (U)
    public void atualizar(Long id, Usuario produtoAtualizado) {
        Optional<Usuario> produtoOptional = usuarioRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Usuario produtoExistente = produtoOptional.get();
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setEmail(produtoAtualizado.getEmail());
            produtoExistente.setEndereco(produtoAtualizado.getEndereco());
            usuarioRepository.save(produtoExistente);
        }
    }

    // DELETE (D)
    public void deletar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        }
    }

    public void deletarTodos() {
        usuarioRepository.deleteAll();
    }

    public Optional<Usuario> buscarPorEmailESenha(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

}
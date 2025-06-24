//Responsável pela página web onde o usuário pode fazer login no sistema.
package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Usuario;
import com.afm.trabalho_ps.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/usuarios")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    public Optional<Usuario> buscarPorSenha(String senha) {
        return usuarioRepository.findBySenha(senha);
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.ok(salvo);
    }

}
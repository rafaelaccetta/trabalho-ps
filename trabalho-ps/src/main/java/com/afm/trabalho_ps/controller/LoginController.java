package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Usuario;
import com.afm.trabalho_ps.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String senha = loginData.get("senha");
        Optional<Usuario> usuario = usuarioService.buscarPorEmailESenha(email, senha);
        if (usuario.isPresent()) {
            // Retorna um token fake junto com o nome e email
            Map<String, Object> response = Map.of(
                "token", java.util.UUID.randomUUID().toString(),
                "nome", usuario.get().getNome(),
                "email", usuario.get().getEmail()
            );
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }
}

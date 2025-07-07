package com.afm.trabalho_ps.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.afm.trabalho_ps.service.UsuarioService;

@Component
public class GerenciadorNotificacaoEmail implements GerenciadorNotificacao{

    private List<EmailListener> admins = new ArrayList<>();

    @Autowired
    public GerenciadorNotificacaoEmail(UsuarioService usuarioService) {
        // Busca todos usuários com email contendo '@admin' e adiciona como Admin
        this.admins = usuarioService.listarAdmins().stream()
            .map(u -> {
                Admin admin = new Admin();
                admin.setId(u.getId());
                admin.setNome(u.getNome());
                admin.setEmail(u.getEmail());
                admin.setEndereco(u.getEndereco());
                admin.setDataNascimento(u.getDataNascimento());
                admin.setSenha(u.getSenha());
                admin.setTelefone(u.getTelefone());
                return admin;
            })
            .collect(Collectors.toList());
    }

    public void notificaFaltaDeInsumo(Insumo insumo){
        for (EmailListener admin : admins){
            admin.receberNotificacaoPorEmail("Foi necessário recusar uma encomenda porque o insumo " + insumo.getNome() + " não tem a quantidade necessária.");
        }
    }

}

package com.afm.trabalho_ps.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GerenciadorNotificacaoEmail implements GerenciadorNotificacao{

    private List<EmailListener> admins;

    public void notificaFaltaDeInsumo(Insumo insumo){
        for (EmailListener admin : admins){
            admin.receberNotificacaoPorEmail("Foi necessário recusar uma encomenda porque o insumo " + insumo.getNome() + " não tem a quantidade necessária.");
        }
    }

}

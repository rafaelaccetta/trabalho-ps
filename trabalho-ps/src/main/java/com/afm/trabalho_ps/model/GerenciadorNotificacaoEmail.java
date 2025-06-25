package com.afm.trabalho_ps.model;

import java.util.List;

public class GerenciadorNotificacaoEmail implements GerenciadorNotificacao{

    private List<EmailListener> admins;

    //IMPLEMENTAR SINGLETON

    public void notificaFaltaDeInsumo(Insumo insumo){
        for (EmailListener admin : admins){
            admin.receberNotificacaoPorEmail("Foi necessário recusar uma encomenda porque o insumo " + insumo.getNome() + " não tem a quantidade necessária.");
        }
    }

    public void notificaRespostaEncomenda(Usuario cliente, Produto produto, int quantidade, boolean confirmado){

    }

}

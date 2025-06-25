package com.afm.trabalho_ps.model;

public class Admin extends Usuario{

    public void receberNotificacaoPorEmail(String mensagem){
        System.out.println("E-mail para: " + this.getEmail() + "\n Mensagem: " + mensagem);
    }

}

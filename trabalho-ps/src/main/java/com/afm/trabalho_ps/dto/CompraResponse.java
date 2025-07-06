package com.afm.trabalho_ps.dto;

public class CompraResponse {
    private boolean sucesso;
    private String mensagem;
    private int quantidadeDisponivel;
    private String nomeProduto;

    public CompraResponse() {
    }

    public CompraResponse(boolean sucesso, String mensagem, int quantidadeDisponivel, String nomeProduto) {
        this.sucesso = sucesso;
        this.mensagem = mensagem;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.nomeProduto = nomeProduto;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}

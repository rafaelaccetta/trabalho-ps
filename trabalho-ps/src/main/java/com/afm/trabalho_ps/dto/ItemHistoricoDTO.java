package com.afm.trabalho_ps.dto;

public class ItemHistoricoDTO {
    public String nomeProduto;
    public int quantidade;
    public double preco;

    public ItemHistoricoDTO(String nomeProduto, int quantidade, double preco) {
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

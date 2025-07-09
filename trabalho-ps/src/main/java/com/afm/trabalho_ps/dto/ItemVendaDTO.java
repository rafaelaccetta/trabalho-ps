package com.afm.trabalho_ps.dto;

public class ItemVendaDTO {
	public Long id;
    public String nomeProduto;
    public int quantidade;
    public double preco;

    public ItemVendaDTO(Long id, String nomeProduto, int quantidade, double preco) {
    	this.id = id;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}

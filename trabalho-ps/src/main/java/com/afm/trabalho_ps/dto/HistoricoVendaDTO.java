package com.afm.trabalho_ps.dto;

import java.time.LocalDate;
import java.util.List;

public class HistoricoVendaDTO {
    private Long id;
    private String estado;
    private Double total;
    private LocalDate data;
    private List<ItemHistoricoDTO> itens;

    public static class ItemHistoricoDTO {
        private String nomeProduto;
        private int quantidade;
        private double preco;

        public String getNomeProduto() { return nomeProduto; }
        public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }

        public int getQuantidade() { return quantidade; }
        public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

        public double getPreco() { return preco; }
        public void setPreco(double preco) { this.preco = preco; }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public List<ItemHistoricoDTO> getItens() { return itens; }
    public void setItens(List<ItemHistoricoDTO> itens) { this.itens = itens; }
}

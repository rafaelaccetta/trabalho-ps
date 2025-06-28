package com.afm.trabalho_ps.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class RelatorioVendasDTO {
    public static class VendaResumo {
        public Long id;
        public LocalDate data;
        public String cliente;
        public BigDecimal valorTotal;
        public List<ItemResumo> itens;
    }
    public static class ItemResumo {
        public String produto;
        public int quantidade;
    }

    public List<VendaResumo> vendas;
    public BigDecimal totalVendido;
    public int totalItensVendidos;
    public String produtoMaisVendido;
    public int quantidadeMaisVendida;
}

package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;

public class RelatorioVendasDetalhadoStrategy implements RelatorioVendasStrategy {
    @Override
    public void imprimirRelatorio(RelatorioVendasDTO dto) {
        System.out.println("\n===== RELATÓRIO DE VENDAS (DETALHADO) =====\n");
        System.out.println("Total vendido: " + dto.totalVendido);
        System.out.println("Total de itens vendidos: " + dto.totalItensVendidos);
        System.out.println("Produto mais vendido: " + dto.produtoMaisVendido + " (" + dto.quantidadeMaisVendida + ")\n");
        for (RelatorioVendasDTO.VendaResumo vendaResumo : dto.vendas) {
            System.out.println("Venda #" + vendaResumo.id + " | Cliente: " + vendaResumo.cliente + " | Data: " + vendaResumo.data + " | Valor: " + vendaResumo.valorTotal);
            for (RelatorioVendasDTO.ItemResumo item : vendaResumo.itens) {
                System.out.println("    - " + item.produto + ": " + item.quantidade);
            }
            System.out.println();
        }
    }
}

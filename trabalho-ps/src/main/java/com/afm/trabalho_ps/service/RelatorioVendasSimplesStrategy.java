package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;

public class RelatorioVendasSimplesStrategy implements RelatorioVendasStrategy {
    @Override
    public void imprimirRelatorio(RelatorioVendasDTO dto) {
        System.out.println("\n===== RELATÓRIO DE VENDAS (SIMPLES) =====\n");
        System.out.println("Total vendido: " + dto.totalVendido);
        System.out.println("Total de itens vendidos: " + dto.totalItensVendidos);
        System.out.println("Produto mais vendido: " + dto.produtoMaisVendido + " (" + dto.quantidadeMaisVendida + ")\n");
    }
}

package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;

public class RelatorioVendasSimplesStrategy implements RelatorioVendasStrategy {
    @Override
    public String gerarRelatorio(RelatorioVendasDTO dto) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== RELATÓRIO DE VENDAS (SIMPLES) =====\n\n");
        sb.append("Total vendido: ").append(dto.totalVendido).append("\n");
        sb.append("Total de itens vendidos: ").append(dto.totalItensVendidos).append("\n");
        sb.append("Produto mais vendido: ").append(dto.produtoMaisVendido).append(" (").append(dto.quantidadeMaisVendida).append(")\n\n");
        return sb.toString();
    }
}

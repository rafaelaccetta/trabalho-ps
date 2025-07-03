package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;

public class RelatorioVendasDetalhadoStrategy implements RelatorioVendasStrategy {
    @Override
    public String gerarRelatorio(RelatorioVendasDTO dto) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===== RELATÓRIO DE VENDAS (DETALHADO) =====\n\n");
        sb.append("Total vendido: ").append(dto.totalVendido).append("\n");
        sb.append("Total de itens vendidos: ").append(dto.totalItensVendidos).append("\n");
        sb.append("Produto mais vendido: ").append(dto.produtoMaisVendido).append(" (").append(dto.quantidadeMaisVendida).append(")\n\n");
        for (RelatorioVendasDTO.VendaResumo vendaResumo : dto.vendas) {
            sb.append("Venda #").append(vendaResumo.id)
              .append(" | Cliente: ").append(vendaResumo.cliente)
              .append(" | Data: ").append(vendaResumo.data)
              .append(" | Valor: ").append(vendaResumo.valorTotal).append("\n");
            for (RelatorioVendasDTO.ItemResumo item : vendaResumo.itens) {
                sb.append("    - ").append(item.produto).append(": ").append(item.quantidade).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

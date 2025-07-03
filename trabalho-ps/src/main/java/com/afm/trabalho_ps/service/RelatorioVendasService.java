package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;
import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.model.ItemVenda;
import com.afm.trabalho_ps.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class RelatorioVendasService {
    @Autowired
    private VendaRepository vendaRepository;

    private RelatorioVendasStrategy strategy = new RelatorioVendasDetalhadoStrategy(); // padrão detalhado

    public RelatorioVendasDTO gerarRelatorio() {
        List<Venda> vendas = vendaRepository.findAll();
        RelatorioVendasDTO dto = new RelatorioVendasDTO();
        dto.vendas = new ArrayList<>();
        BigDecimal totalVendido = BigDecimal.ZERO;
        int totalItens = 0;
        Map<String, Integer> produtoQuantidade = new HashMap<>();

        for (Venda venda : vendas) {
            RelatorioVendasDTO.VendaResumo vendaResumo = new RelatorioVendasDTO.VendaResumo();
            vendaResumo.id = venda.getId();
            vendaResumo.data = venda.getData();
            vendaResumo.cliente = venda.getUsuario() != null ? venda.getUsuario().getNome() : "";
            vendaResumo.valorTotal = venda.getTotal() != null ? BigDecimal.valueOf(venda.getTotal()) : BigDecimal.ZERO;
            vendaResumo.itens = new ArrayList<>();
            totalVendido = totalVendido.add(vendaResumo.valorTotal);

            if (venda.getItens() != null) {
                for (ItemVenda item : venda.getItens()) {
                    String nomeProduto = item.getItemProduto() != null && item.getItemProduto().getProduto() != null ? item.getItemProduto().getProduto().getNome() : "";
                    int qtd = item.getQuantidade();
                    RelatorioVendasDTO.ItemResumo itemResumo = new RelatorioVendasDTO.ItemResumo();
                    itemResumo.produto = nomeProduto;
                    itemResumo.quantidade = qtd;
                    vendaResumo.itens.add(itemResumo);
                    totalItens += qtd;
                    produtoQuantidade.put(nomeProduto, produtoQuantidade.getOrDefault(nomeProduto, 0) + qtd);
                }
            }
            dto.vendas.add(vendaResumo);
        }
        dto.totalVendido = totalVendido;
        dto.totalItensVendidos = totalItens;
        dto.produtoMaisVendido = produtoQuantidade.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
        dto.quantidadeMaisVendida = produtoQuantidade.values().stream().max(Integer::compareTo).orElse(0);
        return dto;
    }

    public void setStrategy(RelatorioVendasStrategy strategy) {
        this.strategy = strategy;
    }

    public String gerarRelatorioFormatado() {
        RelatorioVendasDTO dto = gerarRelatorio();
        return strategy.gerarRelatorio(dto);
    }

    // O método antigo pode ser removido futuramente
    public void imprimirRelatorio() {
        System.out.println(gerarRelatorioFormatado());
    }
}

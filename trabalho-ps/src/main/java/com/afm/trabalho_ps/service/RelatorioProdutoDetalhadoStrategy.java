package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import java.util.List;

public class RelatorioProdutoDetalhadoStrategy implements RelatorioProdutoStrategy {
    @Override
    public Object gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        // Monta um objeto estruturado para o relatório detalhado
        List<Object> relatorio = new java.util.ArrayList<>();
        for (Produto produto : produtos) {
            java.util.Map<String, Object> prodMap = new java.util.HashMap<>();
            prodMap.put("nome", produto.getNome());
            prodMap.put("descricao", produto.getDescricao());
            java.util.List<java.util.Map<String, Object>> ingredientesList = new java.util.ArrayList<>();
            for (Ingrediente ing : ingredientes) {
                if (ing.getIdProduto() == produto.getId()) {
                    Insumo insumo = insumos.stream().filter(i -> i.getId().equals(ing.getIdInsumo())).findFirst().orElse(null);
                    String nomeInsumo = insumo != null ? insumo.getNome() : "(Insumo não encontrado)";
                    java.util.Map<String, Object> ingMap = new java.util.HashMap<>();
                    ingMap.put("insumo", nomeInsumo);
                    ingMap.put("quantidade", ing.getQuantidade());
                    ingMap.put("unidadeMedida", ing.getUnidadeMedida() != null ? ing.getUnidadeMedida() : "mg");
                    ingredientesList.add(ingMap);
                }
            }
            prodMap.put("ingredientes", ingredientesList);
            relatorio.add(prodMap);
        }
        return relatorio;
    }
}

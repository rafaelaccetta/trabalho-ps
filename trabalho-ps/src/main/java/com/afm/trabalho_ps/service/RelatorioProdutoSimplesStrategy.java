package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import java.util.List;

public class RelatorioProdutoSimplesStrategy implements RelatorioProdutoStrategy {
    @Override
    public Object gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        // Retorna apenas os nomes dos produtos
        java.util.List<String> nomes = new java.util.ArrayList<>();
        for (Produto produto : produtos) {
            nomes.add(produto.getNome());
        }
        return nomes;
    }
}

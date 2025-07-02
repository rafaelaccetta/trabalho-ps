package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import java.util.List;

public class RelatorioProdutoDetalhadoStrategy implements RelatorioProdutoStrategy {
    @Override
    public void imprimirRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        System.out.println("\n===== RELATÓRIO DETALHADO DE PRODUTOS E INGREDIENTES =====\n");
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            boolean temIngrediente = false;
            for (Ingrediente ing : ingredientes) {
                if (ing.getIdProduto() == produto.getId()) {
                    Insumo insumo = insumos.stream().filter(i -> i.getId().equals(ing.getIdInsumo())).findFirst().orElse(null);
                    String nomeInsumo = insumo != null ? insumo.getNome() : "(Insumo não encontrado)";
                    System.out.println("  - " + nomeInsumo + ": " + ing.getQuantidade());
                    temIngrediente = true;
                }
            }
            if (!temIngrediente) {
                System.out.println("  Nenhum ingrediente cadastrado.");
            }
            System.out.println();
        }
    }
}

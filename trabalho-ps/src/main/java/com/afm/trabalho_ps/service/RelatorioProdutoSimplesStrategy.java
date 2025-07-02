package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import java.util.List;

public class RelatorioProdutoSimplesStrategy implements RelatorioProdutoStrategy {
    @Override
    public void imprimirRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        System.out.println("\n===== RELATÓRIO SIMPLES DE PRODUTOS =====\n");
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome());
        }
    }
}

package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.repository.ProdutoRepository;
import com.afm.trabalho_ps.repository.IngredienteRepository;
import com.afm.trabalho_ps.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelatorioProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private InsumoRepository insumoRepository;

    public void imprimirRelatorioProdutosEIngredientes() {
        System.out.println("\n===== RELATÓRIO DE PRODUTOS E INGREDIENTES =====");
        for (Produto produto : produtoRepository.findAll()) {
            System.out.println("Produto: " + produto.getNome());
            System.out.println("Descrição: " + produto.getDescricao());
            var ingredientes = ingredienteRepository.findAll().stream()
                .filter(i -> i.getIdProduto() == produto.getId())
                .toList();
            if (ingredientes.isEmpty()) {
                System.out.println("  Nenhum ingrediente cadastrado.");
            } else {
                for (Ingrediente ing : ingredientes) {
                    Insumo insumo = insumoRepository.findById(ing.getIdInsumo()).orElse(null);
                    String nomeInsumo = insumo != null ? insumo.getNome() : "(Insumo não encontrado)";
                    System.out.println("  - " + nomeInsumo + ": " + ing.getQuantidade());
                }
            }
            System.out.println();
        }
    }
}

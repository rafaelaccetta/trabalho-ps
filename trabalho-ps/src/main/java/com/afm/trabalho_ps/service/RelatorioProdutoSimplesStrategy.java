package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.dto.RelatorioProdutoDTO;
import com.afm.trabalho_ps.dto.ProdutoDTO;
import java.util.List;
import java.util.ArrayList;

public class RelatorioProdutoSimplesStrategy implements RelatorioProdutoStrategy {
    @Override
    public RelatorioProdutoDTO gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        RelatorioProdutoDTO dto = new RelatorioProdutoDTO();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO prodDTO = new ProdutoDTO();
            prodDTO.nome = produto.getNome();
            prodDTO.descricao = produto.getDescricao();
            prodDTO.ingredientes = new ArrayList<>(); // Simples: não inclui ingredientes
            produtosDTO.add(prodDTO);
        }
        dto.produtos = produtosDTO;
        return dto;
    }
}

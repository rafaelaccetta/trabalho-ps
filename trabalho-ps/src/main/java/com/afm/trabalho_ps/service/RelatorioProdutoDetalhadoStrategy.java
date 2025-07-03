package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.dto.RelatorioProdutoDTO;
import com.afm.trabalho_ps.dto.ProdutoDTO;
import com.afm.trabalho_ps.dto.IngredienteDTO;
import java.util.List;
import java.util.ArrayList;

public class RelatorioProdutoDetalhadoStrategy implements RelatorioProdutoStrategy {
    @Override
    public RelatorioProdutoDTO gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos) {
        RelatorioProdutoDTO dto = new RelatorioProdutoDTO();
        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO prodDTO = new ProdutoDTO();
            prodDTO.nome = produto.getNome();
            prodDTO.descricao = produto.getDescricao();
            List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
            for (Ingrediente ing : ingredientes) {
                if (ing.getIdProduto() == produto.getId()) {
                    Insumo insumo = insumos.stream().filter(i -> i.getId().equals(ing.getIdInsumo())).findFirst().orElse(null);
                    IngredienteDTO ingDTO = new IngredienteDTO();
                    ingDTO.insumo = insumo != null ? insumo.getNome() : "(Insumo não encontrado)";
                    ingDTO.quantidade = ing.getQuantidade();
                    ingDTO.unidadeMedida = ing.getUnidadeMedida() != null ? ing.getUnidadeMedida() : "mg";
                    ingredientesDTO.add(ingDTO);
                }
            }
            prodDTO.ingredientes = ingredientesDTO;
            produtosDTO.add(prodDTO);
        }
        dto.produtos = produtosDTO;
        return dto;
    }
}

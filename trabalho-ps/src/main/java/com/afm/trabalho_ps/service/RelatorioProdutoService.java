package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.repository.ProdutoRepository;
import com.afm.trabalho_ps.repository.IngredienteRepository;
import com.afm.trabalho_ps.repository.InsumoRepository;
import com.afm.trabalho_ps.dto.RelatorioProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private InsumoRepository insumoRepository;

    private RelatorioProdutoStrategy strategy = new RelatorioProdutoDetalhadoStrategy(); // Padrão: detalhado

    public void setStrategy(RelatorioProdutoStrategy strategy) {
        this.strategy = strategy;
    }

    public RelatorioProdutoDTO gerarRelatorioProdutosEIngredientes() {
        List<Produto> produtos = produtoRepository.findAll();
        List<Ingrediente> ingredientes = ingredienteRepository.findAll();
        List<Insumo> insumos = insumoRepository.findAll();
        return strategy.gerarRelatorio(produtos, ingredientes, insumos);
    }
}

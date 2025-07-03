package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.dto.RelatorioProdutoDTO;
import java.util.List;

public interface RelatorioProdutoStrategy {
    RelatorioProdutoDTO gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos);
}

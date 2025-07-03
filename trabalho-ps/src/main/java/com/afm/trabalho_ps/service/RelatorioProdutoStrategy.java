package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import java.util.List;

public interface RelatorioProdutoStrategy {
    Object gerarRelatorio(List<Produto> produtos, List<Ingrediente> ingredientes, List<Insumo> insumos);
}

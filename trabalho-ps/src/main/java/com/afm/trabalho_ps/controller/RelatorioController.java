package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;
import com.afm.trabalho_ps.service.RelatorioProdutoService;
import com.afm.trabalho_ps.service.RelatorioVendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorio")
@CrossOrigin(origins = "http://localhost:5173")
public class RelatorioController {
    @Autowired
    private RelatorioVendasService relatorioService;
    @Autowired
    private RelatorioProdutoService relatorioProdutoService;

    @GetMapping("/vendas")
    public RelatorioVendasDTO relatorioVendas() {
        return relatorioService.gerarRelatorio();
    }

    @GetMapping("/produtos")
    public Object relatorioProdutos() {
        return relatorioProdutoService.gerarRelatorioProdutosEIngredientes();
    }
}

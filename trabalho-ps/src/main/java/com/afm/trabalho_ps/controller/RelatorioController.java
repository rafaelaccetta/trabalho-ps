package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;
import com.afm.trabalho_ps.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/relatorio")
public class RelatorioController {
    @Autowired
    private RelatorioService relatorioService;

    @GetMapping("/vendas")
    public RelatorioVendasDTO relatorioVendas() {
        return relatorioService.gerarRelatorio();
    }
}

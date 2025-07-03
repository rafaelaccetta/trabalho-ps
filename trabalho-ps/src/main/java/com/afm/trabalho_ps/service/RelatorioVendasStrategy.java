package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.RelatorioVendasDTO;

public interface RelatorioVendasStrategy {
    String gerarRelatorio(RelatorioVendasDTO dto);
}

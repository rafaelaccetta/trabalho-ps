package com.afm.trabalho_ps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Encomenda {
    private Long idCliente;
    private Long idProduto;
    private int quantidade;

}

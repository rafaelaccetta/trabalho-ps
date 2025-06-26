package com.afm.trabalho_ps.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {
    private long idProduto;
    private long idInsumo;
    private long quantidade;
}

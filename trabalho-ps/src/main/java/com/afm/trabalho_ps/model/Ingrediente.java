package com.afm.trabalho_ps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue
    private long id;

    private long idProduto;
    private long idInsumo;
    private int quantidade;
    private String unidadeMedida; // mg ou ml

    public Ingrediente(long idProduto, long idInsumo, int quantidade, String unidadeMedida) {
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
    }
}

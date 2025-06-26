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
    private long quantidade;

    public Ingrediente(long idProduto, long idInsumo, long quantidade) {
        this.idProduto = idProduto;
        this.idInsumo = idInsumo;
        this.quantidade = quantidade;
    }
}

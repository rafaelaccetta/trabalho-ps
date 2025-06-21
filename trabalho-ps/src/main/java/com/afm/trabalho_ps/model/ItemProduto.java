package com.afm.trabalho_ps.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private int quantidade;
    
    private BigDecimal preco;

    public ItemProduto(Produto produto, int quantidade, BigDecimal preco) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

}

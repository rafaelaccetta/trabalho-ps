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
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ItemProduto itemProduto;

    private int quantidade;

    private BigDecimal preco;

    public ItemVenda(ItemProduto itemProduto, int quantidade, BigDecimal preco) {
        this.itemProduto = itemProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    
}

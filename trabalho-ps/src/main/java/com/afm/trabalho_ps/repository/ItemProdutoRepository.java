//Responsável pela lógica de acesso aos dados dos itens de produtos (Produtos em estoque) do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.model.ItemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Long> {
    List<ItemProduto> findAllByProduto_Id(Long produtoId);
}
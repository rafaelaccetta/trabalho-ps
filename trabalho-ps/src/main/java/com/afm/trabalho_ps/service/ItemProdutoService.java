package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.ItemProduto;
import com.afm.trabalho_ps.repository.ItemProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemProdutoService {

    @Autowired
    private ItemProdutoRepository itemProdutoRepository;

    // CRUD: CREATE
    public void salvar(ItemProduto itemProduto) {
        itemProdutoRepository.save(itemProduto);
    }

    // Buscar por ID
    public Optional<ItemProduto> buscarPorId(Long id) {
        return itemProdutoRepository.findById(id);
    }
    
    public List<ItemProduto> buscarPorProdutoId(Long produtoId) {
        return itemProdutoRepository.findAllByProduto_Id(produtoId);
    }

    // CRUD: READ
    public List<ItemProduto> listarTodos() {
        return itemProdutoRepository.findAll();
    }

    // CRUD: UPDATE
    public ItemProduto atualizar(Long id, ItemProduto novoItem) {
        return itemProdutoRepository.findById(id)
            .map(item -> {
                item.setProduto(novoItem.getProduto());
                item.setQuantidade(novoItem.getQuantidade());
                item.setPreco(novoItem.getPreco());
                itemProdutoRepository.save(item);
                return item;
            })
            .orElseThrow(() -> new RuntimeException("ItemProduto não encontrado com ID: " + id));
    }

    // CRUD: DELETE
    public void deletar(Long id) {
        if (!itemProdutoRepository.existsById(id)) {
            throw new RuntimeException("ItemProduto não encontrado com ID: " + id);
        }
        itemProdutoRepository.deleteById(id);
    }
}

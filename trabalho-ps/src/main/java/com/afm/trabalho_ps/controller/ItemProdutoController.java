package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.ItemProduto;
import com.afm.trabalho_ps.service.ItemProdutoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/item-produto")
public class ItemProdutoController {

    @Autowired
    private ItemProdutoService itemProdutoService;

    @GetMapping
    public ResponseEntity<List<ItemProduto>> getByProdutoId(@RequestParam("produtoId") Long produtoId) {
        List<ItemProduto> itens = itemProdutoService.buscarPorProdutoId(produtoId);
        if (itens.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(itens);
    }
}
package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto salvo = produtoService.salvar(produto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<?> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }
}
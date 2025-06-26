package com.afm.trabalho_ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afm.trabalho_ps.model.Encomenda;
import com.afm.trabalho_ps.service.ProdutoService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/encomenda")
public class EncomendaController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public Object encomendarProduto(@RequestBody Encomenda encomenda){
        try{
            return produtoService.encomendarProduto(encomenda);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return Integer.valueOf(2);
        }
    }

}

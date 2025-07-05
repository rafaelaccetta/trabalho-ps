package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Encomenda;
import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.repository.ProdutoRepository;
import com.afm.trabalho_ps.util.TokenResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    private InsumoService insumoService;

    // CONSTRUTOR
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // CREATE (C)
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    // READ (R)
    public Optional<Produto> buscar(Long id) {
        return produtoRepository.findById(id);
    }

    public Iterable<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    // UPDATE (U)
    public void atualizar(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            Produto produtoExistente = produtoOptional.get();
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setDescricao(produtoAtualizado.getDescricao());
            produtoRepository.save(produtoExistente);
        }
    }

    // DELETE (D)
    public void deletar(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
        }
    }

    public void deletarTodos() {
        produtoRepository.deleteAll();
    }

    public TokenResponse encomendarProduto(Encomenda encomenda) throws Exception{
        System.out.println("Recebido idProduto: " + encomenda.getIdProduto());
        System.out.print("Ids de produtos no banco: ");
        for (Produto p : produtoRepository.findAll()) {
            System.out.print(p.getId() + " ");
        }
        System.out.println();
        Optional<Produto> produto = produtoRepository.findById(encomenda.getIdProduto());
        if (produto.isPresent()){
            System.out.println("Produto encontrado: " + produto.get().getNome());
            boolean r = insumoService.verificaInsumos(produto.get(), encomenda.getQuantidade());
            if(r) {
                System.out.println("Insumos suficientes para a encomenda.");
                insumoService.retiraInsumosParaEncomenda(produto.get(), encomenda.getQuantidade());
                return new TokenResponse(1);
            } else {
                System.out.println("Insumos insuficientes para a encomenda.");
                return new TokenResponse(0);
            }
        } else {
            throw new Exception("Produto não encontrado");
        }
    }

    public Long buscarIdPorNome(String nome) {
        for (Produto produto : produtoRepository.findAll()) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto.getId();
            }
        }
        throw new RuntimeException("Insumo não encontrado com nome: " + nome);
    }

}
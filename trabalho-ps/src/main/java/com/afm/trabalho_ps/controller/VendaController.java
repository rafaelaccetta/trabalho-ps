package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.model.ItemVenda;
import com.afm.trabalho_ps.dto.HistoricoVendaDTO;
import com.afm.trabalho_ps.model.ItemProduto;
import com.afm.trabalho_ps.repository.ItemProdutoRepository;
import com.afm.trabalho_ps.repository.VendaRepository;
import com.afm.trabalho_ps.service.VendaService;
import com.afm.trabalho_ps.repository.UsuarioRepository;
import com.afm.trabalho_ps.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ItemProdutoRepository itemProdutoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<?> criarVenda(@RequestBody VendaRequest request) {
        Usuario usuario = null;
        if (request.idUsuario != null) {
            usuario = usuarioRepository.findById(request.idUsuario).orElse(null);
        }
        Venda venda = new Venda();
        venda.setEstado("PENDENTE");
        venda.setData(LocalDate.now());
        venda.setUsuario(usuario);
        venda.setTotal(0.0);
        List<ItemVenda> itens = new ArrayList<>();
        double total = 0.0;
        for (ItemVendaRequest itemReq : request.itens) {
            List<ItemProduto> itensProduto = itemProdutoRepository.findAllByProduto_Id(itemReq.idProduto);
            int quantidadeDisponivel = itensProduto.stream().mapToInt(ItemProduto::getQuantidade).sum();
            if (itensProduto.isEmpty() || quantidadeDisponivel < itemReq.quantidade) {
                return ResponseEntity.badRequest().body("Quantidade indisponível para o produto " + itemReq.idProduto);
            }
            int quantidadeRestante = itemReq.quantidade;
            for (ItemProduto itemProduto : itensProduto) {
                if (quantidadeRestante <= 0) break;
                int usar = Math.min(itemProduto.getQuantidade(), quantidadeRestante);
                if (usar > 0) {
                    ItemVenda itemVenda = new ItemVenda(itemProduto, usar, itemProduto.getPreco());
                    itemVenda.setVenda(venda);
                    itens.add(itemVenda);
                    total += itemProduto.getPreco().doubleValue() * usar;
                    itemProduto.setQuantidade(itemProduto.getQuantidade() - usar);
                    itemProdutoRepository.save(itemProduto);
                    quantidadeRestante -= usar;
                }
            }
        }
        venda.setTotal(total);
        venda.setItens(itens);
        venda.setData(LocalDate.now());
        venda.setEstado("FINALIZADA");
        vendaRepository.save(venda);
        return ResponseEntity.ok(venda);
    }

    public static class VendaRequest {
        public Long idUsuario;
        public List<ItemVendaRequest> itens;
    }
    public static class ItemVendaRequest {
        public Long idProduto;
        public int quantidade;
    }
    
    @GetMapping("/historico")
    public List<HistoricoVendaDTO> getHistoricoPorUsuario(@RequestParam("id") Long id) {
        return vendaService.listarHistoricoPorUsuario(id);
    }

}

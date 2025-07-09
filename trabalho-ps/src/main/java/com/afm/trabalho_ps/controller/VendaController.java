package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.dto.HistoricoVendaDTO;
import com.afm.trabalho_ps.dto.ItemVendaDTO;
import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<?> criarVenda(@RequestBody VendaRequest request) {
        try {
            List<ItemVendaDTO> itens = request.itens.stream()
                    .map(item -> new ItemVendaDTO(
                            item.idProduto,
                            null,
                            item.quantidade,
                            0.0
                    ))
                    .collect(Collectors.toList());

            Venda venda = vendaService.criarVenda(request.idUsuario, itens);
            return ResponseEntity.ok(venda);

        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Erro ao processar a venda: " + ex.getMessage());
        }
    }

    @GetMapping("/historico")
    public List<HistoricoVendaDTO> getHistoricoPorUsuario(@RequestParam("id") Long id) {
        return vendaService.listarHistoricoPorUsuario(id);
    }

    public static class VendaRequest {
        public Long idUsuario;
        public List<ItemVendaRequest> itens;
    }

    public static class ItemVendaRequest {
        public Long idProduto;
        public int quantidade;
    }
}

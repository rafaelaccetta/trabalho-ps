//Responsável pela página web onde o gerente pode gerenciar os insumos do sistema.
package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @PostMapping
    public ResponseEntity<Insumo> criarInsumo(@RequestBody Insumo insumo) {
        Insumo salvo = insumoService.salvar(insumo);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<?> listarInsumos() {
        return ResponseEntity.ok(insumoService.listarTodos());
    }
}
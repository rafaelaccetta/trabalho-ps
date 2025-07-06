package com.afm.trabalho_ps.controller;

import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @PostMapping
    public ResponseEntity<Ingrediente> criarIngrediente(@RequestBody Ingrediente ingrediente) {
        Ingrediente salvo = ingredienteRepository.save(ingrediente);
        return ResponseEntity.ok(salvo);
    }
}

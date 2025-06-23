//Responsável pela lógica de negócios relacionada aos insumos do sistema.

package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    // Retorna todos os insumos cadastrados
    public List<Insumo> buscaTodos() {
        return insumoRepository.findAll();
    }

    // Busca um insumo pelo ID
    public Optional<Insumo> buscaPorId(Long id) {
        return insumoRepository.findById(id);
    }

    // Salva um novo insumo
    public Insumo cria(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    // Atualiza um insumo existente
    public Insumo atualiza(Long id, Insumo insumoDetails) {
        return insumoRepository.findById(id).map(insumo -> {
            insumo.setNome(insumoDetails.getNome());
            insumo.setDescricao(insumoDetails.getDescricao());
            insumo.setQuantidade(insumoDetails.getQuantidade());
            // Adicione outros campos conforme necessário
            return insumoRepository.save(insumo);
        }).orElseThrow(() -> new RuntimeException("Insumo não encontrado com id " + id));
    }

    // Remove um insumo pelo ID
    public void deleta(Long id) {
        insumoRepository.deleteById(id);
    }

    //Remove todos insumos
    public void deletaTodos() {
        insumoRepository.deleteAll();
    }
}
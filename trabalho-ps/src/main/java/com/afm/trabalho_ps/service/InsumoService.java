//Responsável pela lógica de negócios relacionada aos insumos do sistema.

package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.GerenciadorNotificacao;
import com.afm.trabalho_ps.model.Ingrediente;
import com.afm.trabalho_ps.model.Insumo;
import com.afm.trabalho_ps.model.Produto;
import com.afm.trabalho_ps.repository.IngredienteRepository;
import com.afm.trabalho_ps.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private IngredienteRepository ingredienteRepository;

    private GerenciadorNotificacao gerenciadorNotificacao;

    public List<Insumo> listarTodos() {
        return insumoRepository.findAll();
    }

    public Optional<Insumo> buscar(Long id) {
        return insumoRepository.findById(id);
    }

    public Insumo salvar(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    public Insumo atualizar(Long id, Insumo insumoDetails) {
        return insumoRepository.findById(id).map(insumo -> {
            insumo.setNome(insumoDetails.getNome());
            insumo.setDescricao(insumoDetails.getDescricao());
            insumo.setQuantidade(insumoDetails.getQuantidade());
            return insumoRepository.save(insumo);
        }).orElseThrow(() -> new RuntimeException("Insumo não encontrado com id " + id));
    }

    public void deletar(Long id) {
        insumoRepository.deleteById(id);
    }

    public void deletarTodos() {
        insumoRepository.deleteAll();
    }

    public boolean verificaInsumos(Produto produto){
        boolean todosDisponiveis = true;
        List<Ingrediente> ingredientes = ingredienteRepository
            .findAll()
            .stream()
            .filter((ingrediente) -> ingrediente.getIdProduto() == produto.getId())
            .toList();
        for (Ingrediente ingrediente : ingredientes) {
            Insumo insumo = this.buscar(ingrediente.getIdInsumo()).get();
            if(insumo.getQuantidade() < ingrediente.getQuantidade()){
                todosDisponiveis = false;
                gerenciadorNotificacao.notificaFaltaDeInsumo(insumo);
            }
        }
        return todosDisponiveis;
    }
}
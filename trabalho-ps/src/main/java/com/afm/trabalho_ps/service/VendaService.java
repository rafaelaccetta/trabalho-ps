//Responsável pela lógica de negócios relacionada às vendas do sistema.
package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listarTodas() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscarPorId(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

    public Venda atualizar(Long id, Venda detalhesVenda) {
        return vendaRepository.findById(id).map(venda -> {
            venda.setEstado(detalhesVenda.getEstado());
            venda.setTotal(detalhesVenda.getTotal());
            return vendaRepository.save(venda);
        }).orElseThrow(() -> new RuntimeException("Venda não encontrada com id " + id));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    public void deletarTodas() {
        vendaRepository.deleteAll();
    }
}
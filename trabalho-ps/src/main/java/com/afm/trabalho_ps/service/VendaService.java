//Responsável pela lógica de negócios relacionada às vendas do sistema.
package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.HistoricoVendaDTO;
import com.afm.trabalho_ps.dto.ItemHistoricoDTO;
import com.afm.trabalho_ps.model.ItemVenda;
import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            venda.setData(detalhesVenda.getData());
            return vendaRepository.save(venda);
        }).orElseThrow(() -> new RuntimeException("Venda não encontrada com id " + id));
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    public void deletarTodas() {
        vendaRepository.deleteAll();
    }
    
    public List<Venda> listarPorUsuario(Long usuarioId) {
        return vendaRepository.findByUsuarioId(usuarioId);
    }
    
    public List<HistoricoVendaDTO> listarHistoricoPorUsuario(Long usuarioId) {
        List<Venda> vendas = vendaRepository.findByUsuarioId(usuarioId);

        return vendas.stream().map(venda -> {
            HistoricoVendaDTO dto = new HistoricoVendaDTO();
            dto.setId(venda.getId());
            dto.setData(venda.getData());
            dto.setEstado(venda.getEstado());
            dto.setTotal(venda.getTotal());

            List<HistoricoVendaDTO.ItemHistoricoDTO> itensDTO = new ArrayList<>();
            for (ItemVenda item : venda.getItens()) {
                HistoricoVendaDTO.ItemHistoricoDTO itemDTO = new HistoricoVendaDTO.ItemHistoricoDTO();
                itemDTO.setNomeProduto(item.getItemProduto().getProduto().getNome());
                itemDTO.setQuantidade(item.getQuantidade());
                itemDTO.setPreco(item.getPreco().doubleValue());
                itensDTO.add(itemDTO);
            }

            dto.setItens(itensDTO);
            return dto;
        }).toList();
    }


}
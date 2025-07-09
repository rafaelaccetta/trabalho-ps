//Responsável pela lógica de negócios relacionada às vendas do sistema.
package com.afm.trabalho_ps.service;

import com.afm.trabalho_ps.dto.HistoricoVendaDTO;
import com.afm.trabalho_ps.dto.ItemVendaDTO;
import com.afm.trabalho_ps.model.ItemProduto;
import com.afm.trabalho_ps.model.ItemVenda;
import com.afm.trabalho_ps.model.Usuario;
import com.afm.trabalho_ps.model.Venda;
import com.afm.trabalho_ps.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ItemProdutoService itemProdutoService;

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
    
    public Venda criarVenda(Long idUsuario, List<ItemVendaDTO> itensRequest) {
        Usuario usuario = null;
        if (idUsuario != null) {
            usuario = usuarioService.buscar(idUsuario).orElse(null);
        }

        Venda venda = new Venda();
        venda.setEstado("PENDENTE");
        venda.setData(LocalDate.now());
        venda.setUsuario(usuario);
        venda.setTotal(0.0);

        List<ItemVenda> itens = new ArrayList<>();
        double total = 0.0;

        for (ItemVendaDTO itemReq : itensRequest) {
            List<ItemProduto> itensProduto = itemProdutoService.buscarPorProdutoId(itemReq.id);
            int quantidadeDisponivel = itensProduto.stream().mapToInt(ItemProduto::getQuantidade).sum();

            if (itensProduto.isEmpty() || quantidadeDisponivel < itemReq.quantidade) {
                venda.setEstado("CANCELADA");
                salvar(venda);
                throw new RuntimeException("Quantidade indisponível para o produto " + itemReq.id);
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
                    itemProdutoService.salvar(itemProduto);
                    quantidadeRestante -= usar;
                }
            }
        }

        venda.setTotal(total);
        venda.setItens(itens);
        venda.setEstado("FINALIZADA");
        salvar(venda);
        return venda;
    }

}
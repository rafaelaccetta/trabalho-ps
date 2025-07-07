//Responsável pela lógica de acesso aos dados das vendas do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.dto.HistoricoVendaDTO;
import com.afm.trabalho_ps.model.Venda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findByUsuarioId(Long usuarioId);
}
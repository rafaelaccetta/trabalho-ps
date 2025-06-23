//Responsável pela lógica de acesso aos dados das vendas do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
//Responsável pela lógica de acesso aos dados dos insumos do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
}


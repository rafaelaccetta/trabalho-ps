//Responsável pela lógica de acesso aos dados dos produtos do sistema.

package com.afm.trabalho_ps.repository; 

import com.afm.trabalho_ps.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;       
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
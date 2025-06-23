//Responsável pela lógica de acesso aos dados dos usuários do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
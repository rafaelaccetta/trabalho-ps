//Responsável pela lógica de acesso aos dados dos usuários do sistema.

package com.afm.trabalho_ps.repository;

import com.afm.trabalho_ps.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findBySenha(String senha);
}
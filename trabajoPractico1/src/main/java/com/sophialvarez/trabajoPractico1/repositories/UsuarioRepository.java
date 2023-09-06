package com.sophialvarez.trabajoPractico1.repositories;

import com.sophialvarez.trabajoPractico1.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

package com.sophialvarez.trabajoPractico1.repositories;

import com.sophialvarez.trabajoPractico1.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

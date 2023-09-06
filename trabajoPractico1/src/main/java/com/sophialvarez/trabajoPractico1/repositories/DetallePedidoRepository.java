package com.sophialvarez.trabajoPractico1.repositories;

import com.sophialvarez.trabajoPractico1.entities.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallesPedido, Long> {
}

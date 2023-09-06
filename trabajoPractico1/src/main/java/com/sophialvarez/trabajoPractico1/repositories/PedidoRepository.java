package com.sophialvarez.trabajoPractico1.repositories;

import com.sophialvarez.trabajoPractico1.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

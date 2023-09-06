package com.sophialvarez.trabajoPractico1.repositories;


import com.sophialvarez.trabajoPractico1.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}

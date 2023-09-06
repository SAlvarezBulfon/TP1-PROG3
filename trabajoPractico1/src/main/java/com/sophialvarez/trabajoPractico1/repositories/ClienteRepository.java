package com.sophialvarez.trabajoPractico1.repositories;


import com.sophialvarez.trabajoPractico1.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

package com.sophialvarez.trabajoPractico1.repositories;

import com.sophialvarez.trabajoPractico1.entities.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {
}

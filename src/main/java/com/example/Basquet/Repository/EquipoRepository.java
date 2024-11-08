package com.example.Basquet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Basquet.Entity.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{

}

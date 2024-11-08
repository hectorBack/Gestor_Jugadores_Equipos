package com.example.Basquet.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Basquet.Entity.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
	List<Jugador> findByNombreContainingIgnoreCase(String nombre);

}

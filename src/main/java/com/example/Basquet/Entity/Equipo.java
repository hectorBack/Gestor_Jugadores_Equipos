package com.example.Basquet.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Equipo {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nombre;

	    @ManyToOne
	    @JoinColumn(name = "categoria_id", nullable = false)
	    private Categoria categoria;
	    
	    @ManyToMany
	    @JoinTable(
	        name = "equipo_jugador",
	        joinColumns = @JoinColumn(name = "equipo_id"),
	        inverseJoinColumns = @JoinColumn(name = "jugador_id")
	    )
	    private Set<Jugador> jugadores = new HashSet<>();

	    private String entrenador;

		public Equipo(Long id, String nombre, Categoria categoria, Set<Jugador> jugadores, String entrenador) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.categoria = categoria;
			this.jugadores = jugadores;
			this.entrenador = entrenador;
		}

		public Equipo() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}

		public Set<Jugador> getJugadores() {
			return jugadores;
		}

		public void setJugadores(Set<Jugador> jugadores) {
			this.jugadores = jugadores;
		}

		public String getEntrenador() {
			return entrenador;
		}

		public void setEntrenador(String entrenador) {
			this.entrenador = entrenador;
		}

		
}

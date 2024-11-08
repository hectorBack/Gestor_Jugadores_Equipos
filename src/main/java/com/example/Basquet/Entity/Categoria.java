package com.example.Basquet.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
    private int edadMinima;
    private int edadMaxima;
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
	public int getEdadMinima() {
		return edadMinima;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public int getEdadMaxima() {
		return edadMaxima;
	}
	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}
	public Categoria(Long id, String nombre, int edadMinima, int edadMaxima) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
	}
	public Categoria() {
		super();
	}
    
	

}

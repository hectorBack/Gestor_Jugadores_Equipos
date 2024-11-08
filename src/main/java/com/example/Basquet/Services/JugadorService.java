package com.example.Basquet.Services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Basquet.Entity.Categoria;
import com.example.Basquet.Entity.Jugador;
import com.example.Basquet.Repository.JugadorRepository;

@Service
public class JugadorService {
	
	@Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private CategoriaService categoriaService;

    // Método para asignar categoría a un jugador basándose en su edad
    public Categoria asignarCategoria(Jugador jugador) {
        int edad = Period.between(jugador.getFechaNacimiento(), LocalDate.now()).getYears();
        return categoriaService.obtenerCategorias().stream()
                .filter(categoria -> edad >= categoria.getEdadMinima() && edad <= categoria.getEdadMaxima())
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra una categoría adecuada
    }

    // Método para guardar un jugador con su categoría asignada
    public Jugador guardarJugador(Jugador jugador) {
        Categoria categoria = asignarCategoria(jugador);
        jugador.setCategoria(categoria);
        return jugadorRepository.save(jugador);
    }

    // Método para obtener todos los jugadores
    public List<Jugador> obtenerJugadores() {
        return jugadorRepository.findAll();
    }

    // Método para obtener un jugador por su ID
    public Jugador obtenerJugadorPorId(Long id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    // Método para eliminar un jugador por su ID
    public void eliminarJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
    
    // Metodo para buscar por nombre
    public List<Jugador> buscarPorNombre(String nombre) {
        return jugadorRepository.findByNombreContainingIgnoreCase(nombre);
    }


}

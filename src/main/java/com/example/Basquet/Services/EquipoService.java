package com.example.Basquet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Basquet.Entity.Equipo;
import com.example.Basquet.Repository.EquipoRepository;

@Service
public class EquipoService {
	
	@Autowired
    private EquipoRepository equipoRepository;

    public List<Equipo> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> obtenerEquipoPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo guardarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public Equipo actualizarEquipo(Long id, Equipo equipoActualizado) {
        return equipoRepository.findById(id).map(equipo -> {
            equipo.setNombre(equipoActualizado.getNombre());
            equipo.setCategoria(equipoActualizado.getCategoria());
            equipo.setEntrenador(equipoActualizado.getEntrenador());
            return equipoRepository.save(equipo);
        }).orElseGet(() -> {
            equipoActualizado.setId(id);
            return equipoRepository.save(equipoActualizado);
        });
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }

}

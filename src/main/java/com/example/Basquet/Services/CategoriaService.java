package com.example.Basquet.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Basquet.Entity.Categoria;
import com.example.Basquet.Repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
    private CategoriaRepository categoriaRepository;

    // Método para obtener todas las categorías
    public List<Categoria> obtenerCategorias() {
        return categoriaRepository.findAll();
    }

    // Método para obtener una categoría por su ID
    public Categoria obtenerCategoriaPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    // Método para guardar una nueva categoría
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Método para eliminar una categoría por su ID
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

}

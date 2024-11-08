package com.example.Basquet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Basquet.Entity.Categoria;
import com.example.Basquet.Services.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;

    // Listar todas las categorías
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.obtenerCategorias());
        return "categorias/lista"; // archivo Thymeleaf en templates/categorias/lista.html
    }

    // Mostrar formulario para crear una nueva categoría
    @GetMapping("/nuevo")
    public String mostrarFormularioCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario"; // archivo Thymeleaf en templates/categorias/formulario.html
    }

    // Guardar la nueva categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    // Editar una categoría existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaService.obtenerCategoriaPorId(id);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "categorias/formulario";
        } else {
            return "redirect:/categorias";
        }
    }

    // Eliminar una categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias";
    }

}

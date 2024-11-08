package com.example.Basquet.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Basquet.Entity.Equipo;
import com.example.Basquet.Services.CategoriaService;
import com.example.Basquet.Services.EquipoService;
import com.example.Basquet.Services.JugadorService;

@Controller
@RequestMapping("/equipos")
public class EquipoController {
	
	 @Autowired
	    private EquipoService equipoService;

	    @Autowired
	    private CategoriaService categoriaService;

	    @Autowired
	    private JugadorService jugadorService;

	    @GetMapping
	    public String listarEquipos(Model model) {
	        model.addAttribute("equipos", equipoService.obtenerTodosLosEquipos());
	        return "equipo/lista";
	    }

	    @GetMapping("/nuevo")
	    public String mostrarFormularioDeNuevoEquipo(Model model) {
	        model.addAttribute("equipo", new Equipo());
	        model.addAttribute("categorias", categoriaService.obtenerCategorias());
	        model.addAttribute("jugadores", jugadorService.obtenerJugadores());
	        return "equipo/formulario";
	    }

	    @PostMapping("/guardar")
	    public String guardarEquipo(@ModelAttribute Equipo equipo, RedirectAttributes redirectAttributes) {
	        equipoService.guardarEquipo(equipo);
	        redirectAttributes.addFlashAttribute("mensaje", "Equipo guardado exitosamente");
	        return "redirect:/equipos";
	    }

	    @GetMapping("/editar/{id}")
	    public String mostrarFormularioDeEditarEquipo(@PathVariable Long id, Model model) {
	        Equipo equipo = equipoService.obtenerEquipoPorId(id).orElseThrow(() -> new IllegalArgumentException("ID de equipo inválido: " + id));
	        model.addAttribute("equipo", equipo);
	        model.addAttribute("categorias", categoriaService.obtenerCategorias());
	        model.addAttribute("jugadores", jugadorService.obtenerJugadores());
	        return "equipo/formulario";
	    }

	    @PostMapping("/actualizar/{id}")
	    public String actualizarEquipo(@PathVariable Long id, @ModelAttribute Equipo equipoActualizado, RedirectAttributes redirectAttributes) {
	        equipoService.actualizarEquipo(id, equipoActualizado);
	        redirectAttributes.addFlashAttribute("mensaje", "Equipo actualizado exitosamente");
	        return "redirect:/equipos";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarEquipo(@PathVariable Long id, RedirectAttributes redirectAttributes) {
	        equipoService.eliminarEquipo(id);
	        redirectAttributes.addFlashAttribute("mensaje", "Equipo eliminado exitosamente");
	        return "redirect:/equipos";
	    }

}

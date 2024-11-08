package com.example.Basquet.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Basquet.Entity.Categoria;
import com.example.Basquet.Entity.Jugador;
import com.example.Basquet.Services.CategoriaService;
import com.example.Basquet.Services.EquipoService;
import com.example.Basquet.Services.JugadorService;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private EquipoService equipoService;

    // Listar todos los jugadores
    @GetMapping
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorService.obtenerJugadores());
        return "jugadores/lista"; // archivo Thymeleaf en templates/jugadores/lista.html
    }

    // Mostrar formulario para crear un nuevo jugador
    @GetMapping("/nuevo")
    public String mostrarFormularioJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("categorias", categoriaService.obtenerCategorias());
        model.addAttribute("equipos", equipoService.obtenerTodosLosEquipos());
        return "jugadores/formulario"; // archivo Thymeleaf en templates/jugadores/formulario.html
    }

    // Guardar el nuevo jugador y asignar la categoría correspondiente
    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador, @RequestParam("categoria.id") Long categoriaId) {
    	Categoria categoria = categoriaService.obtenerCategoriaPorId(categoriaId);
        jugador.setCategoria(categoria);
        jugadorService.guardarJugador(jugador);
        return "redirect:/jugadores";
    }

    // Editar un jugador existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        Jugador jugador = jugadorService.obtenerJugadorPorId(id);
        if (jugador != null) {
            model.addAttribute("jugador", jugador);
            model.addAttribute("categorias", categoriaService.obtenerCategorias());
            model.addAttribute("equipos", equipoService.obtenerTodosLosEquipos());
            return "jugadores/formulario";
        } else {
            return "redirect:/jugadores";
        }
    }

    // Eliminar un jugador
    @GetMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable("id") Long id) {
        jugadorService.eliminarJugador(id);
        return "redirect:/jugadores";
    }
    
    // Buscar por Nombre
    @GetMapping("/buscar")
    public String listaJugadores(@RequestParam(value = "q", required = false) String q, Model model) {
        List<Jugador> jugadores;
        
        if (q != null && !q.isEmpty()) {
            jugadores = jugadorService.buscarPorNombre(q);
        } else {
            jugadores = jugadorService.obtenerJugadores();
        }
        
        model.addAttribute("jugadores", jugadores);
        return "jugadores/lista";
    }

}

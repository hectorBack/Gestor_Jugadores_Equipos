package com.example.Basquet.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
	
	@GetMapping("/")
    public String mostrarInicio() {
        return "inicio"; // Nombre del archivo HTML sin extensión
    }

}

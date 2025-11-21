package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormularioController {

    @PostMapping("/resultado")
    public String resultado(
            @RequestParam String Nombre,
            @RequestParam String ApellidoP,
            @RequestParam String ApellidoM,
            @RequestParam String Correo,
            @RequestParam String Contraseña,
            Model model
    ) {

        model.addAttribute("Nombre", Nombre);
        model.addAttribute("ApellidoP", ApellidoP);
        model.addAttribute("ApellidoM", ApellidoM);
        model.addAttribute("Correo", Correo);
        model.addAttribute("Contraseña", Contraseña);
        
        return "resultado";
    }

}

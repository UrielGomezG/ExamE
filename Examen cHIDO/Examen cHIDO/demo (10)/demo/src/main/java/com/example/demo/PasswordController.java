package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class PasswordController {

    @PostMapping("/generar")
    public String generar(
            @RequestParam String nombre,
            @RequestParam int numero,
            @RequestParam String palabra,
            @RequestParam String nivel
    ) {

        String base = nombre + numero + palabra;
        String password = "";

        switch (nivel.toLowerCase()) {
            case "bajo":
                password = base + "123";
                break;

            case "medio":
                password = base.toUpperCase() + "@" + (numero * 7);
                break;

            case "alto":
                password = generarAlta(base);
                break;
        }

        return password;
    }

    private String generarAlta(String base) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(base);

        for (int i = 0; i < 10; i++) {
            sb.append(chars.charAt(r.nextInt(chars.length())));
        }

        return sb.toString();
    }
}

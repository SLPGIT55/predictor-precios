package com.example.paginawebjava.controller;

import com.example.paginawebjava.modelo.Producto;
import com.example.paginawebjava.service.PrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PrecioController {

    // Inyecta el servicio que contiene la lógica de cálculo
    @Autowired
    private PrecioService precioService;

    // 1. Maneja la petición GET a la URL de inicio (/) para MOSTRAR el formulario
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        // Añade un objeto Producto vacío al modelo para que el formulario lo rellene
        model.addAttribute("producto", new Producto());
        return "formulario_prediccion"; // Nombre de tu archivo HTML (en /templates)
    }

    // 2. Maneja la petición POST a la URL (/predecir) para PROCESAR los datos
    @PostMapping("/predecir")
    public String predecirPrecio(@ModelAttribute Producto producto, Model model) {

        // Llama al servicio para calcular el precio predicho
        Producto resultado = precioService.predecirPrecio(producto);

        // Añade el objeto con el resultado al modelo
        model.addAttribute("producto", resultado);

        // Vuelve a la misma página del formulario para mostrar el resultado
        return "formulario_prediccion";
    }
}
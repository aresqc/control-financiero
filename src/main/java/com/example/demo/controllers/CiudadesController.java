package com.example.demo.controllers;

import com.example.demo.models.Ciudades;
import com.example.demo.services.CiudadesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/ciudades")
@AllArgsConstructor
public class CiudadesController {

    private final CiudadesService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ciudades", service.listarTodos());
        return "ciudades/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("ciudad", new Ciudades());
        return "ciudades/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ciudades ciudad) {
        service.guardar(ciudad);
        return "redirect:/ciudades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Ciudades> ciudad = service.buscarPorId(id);
        if (ciudad.isPresent()) {
            model.addAttribute("ciudad", ciudad.get());
            return "ciudades/formulario";
        }
        return "redirect:/ciudades";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/ciudades";
    }
}
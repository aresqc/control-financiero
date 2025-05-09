package com.example.demo.controllers;

import com.example.demo.models.Barrios;
import com.example.demo.services.BarriosService;
import com.example.demo.services.CiudadesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/barrios")
@AllArgsConstructor
public class BarriosController {

    private final BarriosService barriosService;
    private final CiudadesService ciudadesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("barrios", barriosService.listarTodos());
        return "barrios/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("barrio", new Barrios());
        model.addAttribute("ciudades", ciudadesService.listarTodos());
        return "barrios/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Barrios barrio) {
        Long ciudadId = barrio.getCiudad().getId();
        barrio.setCiudad(ciudadesService.buscarPorId(ciudadId).orElse(null));
        barriosService.guardar(barrio);
        return "redirect:/barrios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Barrios> barrio = barriosService.buscarPorId(id);
        if (barrio.isPresent()) {
            model.addAttribute("barrio", barrio.get());
            model.addAttribute("ciudades", ciudadesService.listarTodos());
            return "barrios/formulario";
        }
        return "redirect:/barrios";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        barriosService.eliminar(id);
        return "redirect:/barrios";
    }
}
package com.example.demo.controllers;

import com.example.demo.models.Marcas;
import com.example.demo.services.MarcasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/marcas")
@AllArgsConstructor
public class MarcasController {

    private final MarcasService marcaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("marcas", marcaService.listar());
        return "marcas/listar";
    }

    @GetMapping("/form")
    public String formularioNuevo(Model model) {
        model.addAttribute("marca", new Marcas());
        return "marcas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Marcas marca) {
        marcaService.guardar(marca);
        return "redirect:/marcas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Marcas> marca = marcaService.getById(id);
        if (marca.isPresent()) {
            model.addAttribute("marca", marca.get());
            return "marcas/formulario";
        }
        return "redirect:/marcas";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        marcaService.eliminar(id);
        return "redirect:/marcas";
    }
}
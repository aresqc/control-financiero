package com.example.demo.controllers;

import com.example.demo.models.Paises;
import com.example.demo.services.PaisesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/paises")
@AllArgsConstructor
public class PaisesController {

    private final PaisesService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("paises", service.listarTodos());
        return "paises/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pais", new Paises());
        return "paises/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Paises pais) {
        service.guardar(pais);
        return "redirect:/paises";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Paises> pais = service.buscarPorId(id);
        if (pais.isPresent()) {
            model.addAttribute("pais", pais.get());
            return "paises/formulario";
        }
        return "redirect:/paises";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/paises";
    }
}
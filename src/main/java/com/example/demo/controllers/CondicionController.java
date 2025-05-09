package com.example.demo.controllers;

import com.example.demo.models.Condicion;
import com.example.demo.services.CondicionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/condiciones")
@AllArgsConstructor
public class CondicionController {

    private final CondicionService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("condiciones", service.listarTodos());
        return "condicion/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("condicion", new Condicion());
        return "condicion/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Condicion condicion) {
        service.guardar(condicion);
        return "redirect:/condiciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Condicion> condicion = service.buscarPorId(id);
        if (condicion.isPresent()) {
            model.addAttribute("condicion", condicion.get());
            return "condicion/formulario";
        }
        return "redirect:/condiciones";
    }
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/condiciones";
    }
}
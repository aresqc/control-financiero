package com.example.demo.controllers;

import com.example.demo.models.Timbrados;
import com.example.demo.services.TimbradosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/timbrados")
@AllArgsConstructor
public class TimbradosController {

    private final TimbradosService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("listaTimbrados", service.listarTodos());
        return "timbrados/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("timbrado", new Timbrados());
        return "timbrados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Timbrados timbrado) {
        service.guardar(timbrado);
        return "redirect:/timbrados";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Timbrados> timbrado = service.buscarPorId(id);
        if (timbrado.isPresent()) {
            model.addAttribute("timbrado", timbrado.get());
            return "timbrados/formulario";
        }
        return "redirect:/timbrados";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/timbrados";
    }
}
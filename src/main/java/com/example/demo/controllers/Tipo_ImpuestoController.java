package com.example.demo.controllers;

import com.example.demo.models.Tipo_Impuesto;
import com.example.demo.services.Tipo_ImpuestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/tipo_impuesto")
@AllArgsConstructor
public class Tipo_ImpuestoController {

    private final Tipo_ImpuestoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("tiposImpuesto", service.listarTodos());
        return "tipo_impuesto/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("tipoImpuesto", new Tipo_Impuesto());
        return "tipo_impuesto/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Tipo_Impuesto tipoImpuesto) {
        service.guardar(tipoImpuesto);
        return "redirect:/tipo_impuesto";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Tipo_Impuesto> tipo = service.buscarPorId(id);
        if (tipo.isPresent()) {
            model.addAttribute("tipoImpuesto", tipo.get());
            return "tipo_impuesto/formulario";
        }
        return "redirect:/tipo_impuesto";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/tipo_impuesto";
    }
}
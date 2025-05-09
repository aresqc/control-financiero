package com.example.demo.controllers;

import com.example.demo.models.Proveedores;
import com.example.demo.services.ProveedoresService;
import com.example.demo.services.BarriosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/proveedores")
@AllArgsConstructor
public class ProveedoresController {

    private final ProveedoresService service;
    private final BarriosService barriosService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proveedores", service.listarTodos());
        return "proveedores/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proveedor", new Proveedores());
        model.addAttribute("barrios", barriosService.listarTodos());
        return "proveedores/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Proveedores proveedor) {
        service.guardar(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Proveedores> proveedor = service.buscarPorId(id);
        if (proveedor.isPresent()) {
            model.addAttribute("proveedor", proveedor.get());
            model.addAttribute("barrios", barriosService.listarTodos());
            return "proveedores/formulario";
        }
        return "redirect:/proveedores";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        service.eliminar(id);
        return "redirect:/proveedores";
    }
}
package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Mercaderias;
import com.example.demo.services.MercaderiasService;
import com.example.demo.services.MarcasService;
import com.example.demo.services.Tipo_ImpuestoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/mercaderias")
@AllArgsConstructor
public class MercaderiasController {

    private final MercaderiasService mercaderiasService;
    private final MarcasService marcaService;
    private final Tipo_ImpuestoService tipoImpuestoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mercaderias", mercaderiasService.listarTodos());
        return "mercaderias/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mercaderia", new Mercaderias());
        model.addAttribute("marcas", marcaService.listar());
        return "mercaderias/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Mercaderias mercaderia) {
        mercaderiasService.guardar(mercaderia);
        return "redirect:/mercaderias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Mercaderias> mercaderia = mercaderiasService.getById(id);

        if (mercaderia.isPresent()) {
            model.addAttribute("mercaderia", mercaderia.get());
            model.addAttribute("marcas", marcaService.listar());
            model.addAttribute("tiposImpuesto", tipoImpuestoService.listarTodos());
            return "mercaderias/formulario";
        }

        return "redirect:/mercaderias";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        mercaderiasService.eliminar(id);
        return "redirect:/mercaderias";
    }
}
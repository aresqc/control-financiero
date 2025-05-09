package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult; // Importación necesaria para BindingResult
import jakarta.validation.Valid; // Importación necesaria para @Valid

import com.example.demo.models.Bancos;
import com.example.demo.services.BancosService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/bancos")
@AllArgsConstructor
public class BancosController {

    private BancosService bancoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("bancos", bancoService.listar());
        return "bancos/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("banco", new Bancos());
        return "bancos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute Bancos banco, BindingResult result, Model model) {
         if (result.hasErrors()) {
            return "bancos/formulario";
        }

         bancoService.guardar(banco);
        return "redirect:/bancos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Bancos> banco = bancoService.getById(id);

        if (banco.isPresent()) {
            model.addAttribute("banco", banco.get());
            return "bancos/formulario";
        }

        return "redirect:/bancos";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        bancoService.eliminar(id);
        return "redirect:/bancos";
    }
}
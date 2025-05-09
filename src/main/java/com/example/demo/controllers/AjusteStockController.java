package com.example.demo.controllers;

import com.example.demo.models.AjusteStock;
import com.example.demo.services.AjusteStockService;
import com.example.demo.services.MercaderiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ajustestock")
public class AjusteStockController {

    @Autowired private AjusteStockService service;
    @Autowired private MercaderiasService mercaderiasService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ajustes", service.listarTodos());
        return "ajustestock/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("ajuste", new AjusteStock());
        model.addAttribute("mercaderias", mercaderiasService.listarTodos());
        return "ajustestock/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute AjusteStock ajuste) {
        service.guardar(ajuste);
        return "redirect:/ajustestock";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("ajuste", service.buscarPorId(id));
        model.addAttribute("mercaderias", mercaderiasService.listarTodos());
        return "ajustestock/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/ajustestock";
    }
}
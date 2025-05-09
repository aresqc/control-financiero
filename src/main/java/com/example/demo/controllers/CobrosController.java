package com.example.demo.controllers;

import com.example.demo.models.Cobros;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cobros")
public class CobrosController {

    @Autowired private CobrosService service;
    @Autowired private VentasService ventasService;
    @Autowired private BancosService bancosService;
    @Autowired private AperturaCierreService aperturaCierreService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cobros", service.listarTodos());
        return "cobros/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("cobro", new Cobros());
        model.addAttribute("ventas", ventasService.listarTodos());
        model.addAttribute("bancos", bancosService.listarTodos());
        model.addAttribute("aperturas", aperturaCierreService.listarTodos());
        return "cobros/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Cobros cobro) {
        service.guardar(cobro);
        return "redirect:/cobros";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("cobro", service.buscarPorId(id));
        model.addAttribute("ventas", ventasService.listarTodos());
        model.addAttribute("bancos", bancosService.listarTodos());
        model.addAttribute("aperturas", aperturaCierreService.listarTodos());
        return "cobros/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/cobros";
    }
}
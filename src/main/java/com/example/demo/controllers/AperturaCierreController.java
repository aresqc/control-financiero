package com.example.demo.controllers;

import com.example.demo.models.AperturaCierre;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aperturacierre")
public class AperturaCierreController {

    @Autowired private AperturaCierreService service;
    @Autowired private CajasService cajasService;
    @Autowired private UsuariosService usuariosService;
    @Autowired private SucursalesService sucursalesService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("aperturas", service.listarTodos());
        return "aperturacierre/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("apertura", new AperturaCierre());
        model.addAttribute("cajas", cajasService.listarTodos());
        model.addAttribute("usuarios", usuariosService.listarTodos());
        model.addAttribute("sucursales", sucursalesService.listarTodos());
        return "aperturacierre/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute AperturaCierre apertura) {
        service.guardar(apertura);
        return "redirect:/aperturacierre";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("apertura", service.buscarPorId(id));
        model.addAttribute("cajas", cajasService.listarTodos());
        model.addAttribute("usuarios", usuariosService.listarTodos());
        model.addAttribute("sucursales", sucursalesService.listarTodos());
        return "aperturacierre/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/aperturacierre";
    }
}
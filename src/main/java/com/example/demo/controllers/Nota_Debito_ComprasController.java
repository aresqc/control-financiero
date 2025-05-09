package com.example.demo.controllers;

import com.example.demo.models.Nota_Debito_Compras;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notadebitocompras")
public class Nota_Debito_ComprasController {

    @Autowired private Nota_Debito_ComprasService service;
    @Autowired private ComprasService comprasService;
    @Autowired private ProveedoresService proveedorService;
    @Autowired private EmpleadosService empleadoService;
    @Autowired private SucursalesService sucursalService;
    @Autowired private CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("notas", service.listarTodos());
        return "notadebitocompras/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("nota", new Nota_Debito_Compras());
        model.addAttribute("compras", comprasService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "notadebitocompras/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Nota_Debito_Compras nota) {
        service.guardar(nota);
        return "redirect:/notadebitocompras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("nota", service.buscarPorId(id));
        model.addAttribute("compras", comprasService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "notadebitocompras/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/notadebitocompras";
    }
}
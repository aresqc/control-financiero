package com.example.demo.controllers;

import com.example.demo.models.OrdenCompra;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService service;

    @Autowired private PresupuestoComprasService presupuestoService;
    @Autowired private ProveedoresService proveedorService;
    @Autowired private EmpleadosService empleadoService;
    @Autowired private SucursalesService sucursalService;
    @Autowired private CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ordenes", service.listarTodos());
        return "ordencompra/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("orden", new OrdenCompra());
        model.addAttribute("presupuestos", presupuestoService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "ordencompra/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute OrdenCompra orden) {
        service.guardar(orden);
        return "redirect:/ordencompra";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("orden", service.buscarPorId(id));
        model.addAttribute("presupuestos", presupuestoService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "ordencompra/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/ordencompra";
    }
}
package com.example.demo.controllers;

import com.example.demo.models.PresupuestoCompras;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/presupuestocompras")
public class PresupuestoComprasController {

    @Autowired
    private PresupuestoComprasService service;

    @Autowired
    private PedidoComprasService pedidoService;
    @Autowired
    private ProveedoresService proveedorService;
    @Autowired
    private EmpleadosService empleadoService;
    @Autowired
    private SucursalesService sucursalService;
    @Autowired
    private CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("presupuestos", service.listarTodos());
        return "presupuestocompras/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("presupuesto", new PresupuestoCompras());
        model.addAttribute("pedidos", pedidoService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "presupuestocompras/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PresupuestoCompras presupuesto) {
        service.guardar(presupuesto);
        return "redirect:/presupuestocompras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("presupuesto", service.buscarPorId(id));
        model.addAttribute("pedidos", pedidoService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "presupuestocompras/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/presupuestocompras";
    }
}
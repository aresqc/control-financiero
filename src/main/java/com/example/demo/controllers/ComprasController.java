package com.example.demo.controllers;

import com.example.demo.models.Compras;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/compras")
public class ComprasController {

    @Autowired private ComprasService comprasService;
    @Autowired private OrdenCompraService ordenCompraService;
    @Autowired private ProveedoresService proveedorService;
    @Autowired private EmpleadosService empleadoService;
    @Autowired private SucursalesService sucursalService;
    @Autowired private CondicionService condicionService;
    @Autowired private Nota_CreditoComprasService notaCreditoService;
    @Autowired private Nota_Debito_ComprasService notaDebitoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("compras", comprasService.listarTodos());
        return "compras/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("compra", new Compras());
        model.addAttribute("ordenes", ordenCompraService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        model.addAttribute("notasCredito", notaCreditoService.listarTodos());
        model.addAttribute("notasDebito", notaDebitoService.listarTodos());
        return "compras/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Compras compra) {
        comprasService.guardar(compra);
        return "redirect:/compras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("compra", comprasService.buscarPorId(id));
        model.addAttribute("ordenes", ordenCompraService.listarTodos());
        model.addAttribute("proveedores", proveedorService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        model.addAttribute("notasCredito", notaCreditoService.listarTodos());
        model.addAttribute("notasDebito", notaDebitoService.listarTodos());
        return "compras/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        comprasService.eliminar(id);
        return "redirect:/compras";
    }
}
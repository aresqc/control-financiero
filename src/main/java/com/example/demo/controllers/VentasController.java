package com.example.demo.controllers;

import com.example.demo.models.Ventas;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentasController {

    @Autowired private VentasService service;
    @Autowired private TimbradosService timbradoService;
    @Autowired private SucursalesService sucursalService;
    @Autowired private EmpleadosService empleadoService;
    @Autowired private PedidoVentasService pedidoService;
    @Autowired private ClientesService clienteService;
    @Autowired private AperturaCierreService aperturaCierreService;
    @Autowired private CondicionService condicionService;
    @Autowired private Nota_CreditoComprasService notaCreditoService;
    @Autowired private Nota_Debito_ComprasService notaDebitoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ventas", service.listarTodos());
        return "ventas/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("venta", new Ventas());
        model.addAttribute("timbrados", timbradoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("pedidos", pedidoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("aperturas", aperturaCierreService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        model.addAttribute("notasCredito", notaCreditoService.listarTodos());
        model.addAttribute("notasDebito", notaDebitoService.listarTodos());
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Ventas venta) {
        service.guardar(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("venta", service.buscarPorId(id));
        model.addAttribute("timbrados", timbradoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("pedidos", pedidoService.listarTodos());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("aperturas", aperturaCierreService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        model.addAttribute("notasCredito", notaCreditoService.listarTodos());
        model.addAttribute("notasDebito", notaDebitoService.listarTodos());
        return "ventas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/ventas";
    }
}
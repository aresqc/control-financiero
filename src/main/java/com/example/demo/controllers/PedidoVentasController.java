package com.example.demo.controllers;

import com.example.demo.models.PedidoVentas;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidoventas")
public class PedidoVentasController {

    @Autowired private PedidoVentasService service;
    @Autowired private ClientesService clienteService;
    @Autowired private EmpleadosService empleadoService;
    @Autowired private SucursalesService sucursalService;
    @Autowired private CondicionService condicionService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", service.listarTodos());
        return "pedidoventas/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new PedidoVentas());
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "pedidoventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoVentas pedido) {
        service.guardar(pedido);
        return "redirect:/pedidoventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("pedido", service.buscarPorId(id));
        model.addAttribute("clientes", clienteService.listarTodos());
        model.addAttribute("empleados", empleadoService.listarTodos());
        model.addAttribute("sucursales", sucursalService.listarTodos());
        model.addAttribute("condiciones", condicionService.listarTodos());
        return "pedidoventas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/pedidoventas";
    }
}
package com.example.demo.controllers;

import com.example.demo.models.PedidoCompras;
import com.example.demo.services.PedidoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pedidocompras")
public class PedidoComprasController {

    @Autowired
    private PedidoComprasService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("pedidos", service.listarTodos());
        return "pedidocompras/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pedido", new PedidoCompras());
        return "pedidocompras/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute PedidoCompras pedido) {
        service.guardar(pedido);
        return "redirect:/pedidocompras";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("pedido", service.buscarPorId(id));
        return "pedidocompras/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/pedidocompras";
    }
}
package com.example.demo.controllers;

import com.example.demo.models.Empleados;
import com.example.demo.services.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/empleados")
@AllArgsConstructor
public class EmpleadosController {

    private final EmpleadosService empleadosService;
    private final BarriosService barriosService;
    private final PaisesService paisesService;
    private final UsuariosService usuariosService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadosService.listarTodos());
        return "empleados/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleados());
        model.addAttribute("barrios", barriosService.listarTodos());
        model.addAttribute("paises", paisesService.listarTodos());
        model.addAttribute("usuarios", usuariosService.listarTodos());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleados empleado) {
        Long barrioId = empleado.getBarrio().getId();
        Long paisId = empleado.getNacionalidad().getId();
        Long usuarioId = empleado.getUsuario().getId();

        empleado.setBarrio(barriosService.buscarPorId(barrioId).orElse(null));
        empleado.setNacionalidad(paisesService.buscarPorId(paisId).orElse(null));
        empleado.setUsuario(usuariosService.buscarPorId(usuarioId).orElse(null));

        empleadosService.guardar(empleado);
        return "redirect:/empleados";
    }


    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Optional<Empleados> empleado = empleadosService.buscarPorId(id);
        if (empleado.isPresent()) {
            model.addAttribute("empleado", empleado.get());
            model.addAttribute("barrios", barriosService.listarTodos());
            model.addAttribute("paises", paisesService.listarTodos());
            model.addAttribute("usuarios", usuariosService.listarTodos());
            return "empleados/formulario";
        }
        return "redirect:/empleados";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {
        empleadosService.eliminar(id);
        return "redirect:/empleados";
    }
}
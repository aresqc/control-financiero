package com.example.demo.controllers;

import com.example.demo.models.Usuarios;
import com.example.demo.services.RolesService;
import com.example.demo.services.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuariosController {

    private final UsuariosService usuariosService;
    private final RolesService rolesService;

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuariosService.listarTodos());
        return "usuarios/listar";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        model.addAttribute("listadoRoles", rolesService.listarTodos());
        return "usuarios/formulario";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuarios usuario) {
        usuariosService.guardar(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        Optional<Usuarios> usuario = usuariosService.buscarPorId(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            model.addAttribute("listadoRoles", rolesService.listarTodos());
            return "usuarios/formulario";
        }
        return "redirect:/usuarios";
    }

    @PostMapping("/eliminar")
    public String eliminarUsuario(@RequestParam Long id) {
        usuariosService.eliminar(id);
        return "redirect:/usuarios";
    }
}
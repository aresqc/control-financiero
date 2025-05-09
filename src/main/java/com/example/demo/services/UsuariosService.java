package com.example.demo.services;

import com.example.demo.models.Usuarios;
import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    List<Usuarios> listarTodos();
    Optional<Usuarios> buscarPorId(Long id);
    void guardar(Usuarios usuario);
    void eliminar(Long id);
}
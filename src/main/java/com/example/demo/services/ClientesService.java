package com.example.demo.services;

import com.example.demo.models.Clientes;
import java.util.List;
import java.util.Optional;

public interface ClientesService {
    List<Clientes> listarTodos();
    Optional<Clientes> buscarPorId(Long id);
    void guardar(Clientes cliente);
    void eliminar(Long id);
}
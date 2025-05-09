package com.example.demo.services;

import com.example.demo.models.Condicion;
import java.util.List;
import java.util.Optional;

public interface CondicionService {
    List<Condicion> listarTodos();
    Optional<Condicion> buscarPorId(Long id);
    void guardar(Condicion condicion);
    void eliminar(Long id);
}
package com.example.demo.services;

import com.example.demo.models.Paises;
import java.util.List;
import java.util.Optional;

public interface PaisesService {
    List<Paises> listarTodos();
    Optional<Paises> buscarPorId(Long id);
    void guardar(Paises pais);
    void eliminar(Long id);
}
package com.example.demo.services;

import com.example.demo.models.Barrios;
import java.util.List;
import java.util.Optional;

public interface BarriosService {
    List<Barrios> listarTodos();
    Optional<Barrios> buscarPorId(Long id);
    void guardar(Barrios barrio);
    void eliminar(Long id);
}
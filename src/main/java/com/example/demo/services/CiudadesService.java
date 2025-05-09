package com.example.demo.services;

import com.example.demo.models.Ciudades;
import java.util.List;
import java.util.Optional;

public interface CiudadesService {
    List<Ciudades> listarTodos();
    Optional<Ciudades> buscarPorId(Long id);
    void guardar(Ciudades ciudad);
    void eliminar(Long id);
}
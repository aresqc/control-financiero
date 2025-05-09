package com.example.demo.services;

import com.example.demo.models.Empleados;
import java.util.List;
import java.util.Optional;

public interface EmpleadosService {
    List<Empleados> listarTodos();
    Optional<Empleados> buscarPorId(Long id);
    void guardar(Empleados empleado);
    void eliminar(Long id);
}
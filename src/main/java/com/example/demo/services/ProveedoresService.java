package com.example.demo.services;

import com.example.demo.models.Proveedores;
import java.util.List;
import java.util.Optional;

public interface ProveedoresService {
    List<Proveedores> listarTodos();
    Optional<Proveedores> buscarPorId(Long id);
    void guardar(Proveedores proveedor);
    void eliminar(Long id);
}
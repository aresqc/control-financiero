package com.example.demo.services;

import com.example.demo.models.Tipo_Impuesto;
import java.util.List;
import java.util.Optional;

public interface Tipo_ImpuestoService {
    List<Tipo_Impuesto> listarTodos();
    Optional<Tipo_Impuesto> buscarPorId(Long id);
    void guardar(Tipo_Impuesto tipo);
    void eliminar(Long id);
}
package com.example.demo.services;

import com.example.demo.models.Timbrados;
import java.util.List;
import java.util.Optional;

public interface TimbradosService {
    List<Timbrados> listarTodos();
    Optional<Timbrados> buscarPorId(Long id);
    void guardar(Timbrados timbrado);
    void eliminar(Long id);
}
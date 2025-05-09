package com.example.demo.services;

import com.example.demo.models.Ventas;
import java.util.List;

public interface VentasService {
    List<Ventas> listarTodos();
    Ventas guardar(Ventas venta);
    Ventas buscarPorId(Integer id);
    void eliminar(Integer id);
}
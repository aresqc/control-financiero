package com.example.demo.services;

import com.example.demo.models.Compras;
import java.util.List;

public interface ComprasService {
    List<Compras> listarTodos();
    Compras guardar(Compras compra);
    Compras buscarPorId(Integer id);
    void eliminar(Integer id);
}
package com.example.demo.services;

import com.example.demo.models.OrdenCompra;
import java.util.List;

public interface OrdenCompraService {
    List<OrdenCompra> listarTodos();
    OrdenCompra guardar(OrdenCompra orden);
    OrdenCompra buscarPorId(Integer id);
    void eliminar(Integer id);
}
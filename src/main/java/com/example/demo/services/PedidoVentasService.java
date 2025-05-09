package com.example.demo.services;

import com.example.demo.models.PedidoVentas;
import java.util.List;

public interface PedidoVentasService {
    List<PedidoVentas> listarTodos();
    PedidoVentas guardar(PedidoVentas pedido);
    PedidoVentas buscarPorId(Integer id);
    void eliminar(Integer id);
}
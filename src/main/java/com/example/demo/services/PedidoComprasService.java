package com.example.demo.services;

import com.example.demo.models.PedidoCompras;
import java.util.List;

public interface PedidoComprasService {
    List<PedidoCompras> listarTodos();
    PedidoCompras guardar(PedidoCompras pedido);
    PedidoCompras buscarPorId(Integer id);
    void eliminar(Integer id);
}

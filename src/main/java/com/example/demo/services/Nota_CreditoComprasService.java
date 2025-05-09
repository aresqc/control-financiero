package com.example.demo.services;

import com.example.demo.models.Nota_CreditoCompras;
import java.util.List;

public interface Nota_CreditoComprasService {
    List<Nota_CreditoCompras> listarTodos();
    Nota_CreditoCompras guardar(Nota_CreditoCompras nota);
    Nota_CreditoCompras buscarPorId(Integer id);
    void eliminar(Integer id);
}
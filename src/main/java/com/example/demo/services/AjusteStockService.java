package com.example.demo.services;

import com.example.demo.models.AjusteStock;
import java.util.List;

public interface AjusteStockService {
    List<AjusteStock> listarTodos();
    AjusteStock guardar(AjusteStock ajuste);
    AjusteStock buscarPorId(Integer id);
    void eliminar(Integer id);
}
package com.example.demo.services;

import com.example.demo.models.AperturaCierre;
import java.util.List;

public interface AperturaCierreService {
    List<AperturaCierre> listarTodos();
    AperturaCierre guardar(AperturaCierre apertura);
    AperturaCierre buscarPorId(Integer id);
    void eliminar(Integer id);
}
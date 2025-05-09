package com.example.demo.services;

import com.example.demo.models.PresupuestoCompras;
import java.util.List;

public interface PresupuestoComprasService {
    List<PresupuestoCompras> listarTodos();
    PresupuestoCompras guardar(PresupuestoCompras presupuesto);
    PresupuestoCompras buscarPorId(Integer id);
    void eliminar(Integer id);
}
package com.example.demo.services;

import com.example.demo.models.Cobros;
import java.util.List;

public interface CobrosService {
    List<Cobros> listarTodos();
    Cobros guardar(Cobros cobro);
    Cobros buscarPorId(Integer id);
    void eliminar(Integer id);
}
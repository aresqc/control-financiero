package com.example.demo.services;

import com.example.demo.models.Nota_Debito_Compras;
import java.util.List;

public interface Nota_Debito_ComprasService {
    List<Nota_Debito_Compras> listarTodos();
    Nota_Debito_Compras guardar(Nota_Debito_Compras nota);
    Nota_Debito_Compras buscarPorId(Integer id);
    void eliminar(Integer id);
}
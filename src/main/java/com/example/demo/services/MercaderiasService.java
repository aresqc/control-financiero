package com.example.demo.services;

import com.example.demo.models.Mercaderias;
import java.util.List;
import java.util.Optional;

public interface MercaderiasService {
    List<Mercaderias> listarTodos();
    Optional<Mercaderias> buscarPorId(Long id);
    Mercaderias guardar(Mercaderias mercaderia);
    void eliminar(Long id);
	Optional<Mercaderias> getById(Long id);
}
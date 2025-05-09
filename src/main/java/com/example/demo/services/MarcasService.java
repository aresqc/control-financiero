package com.example.demo.services;

import com.example.demo.models.Marcas;

import java.util.List;
import java.util.Optional;

public interface MarcasService {

    List<Marcas> listar();

    Marcas guardar(Marcas marca);

    void eliminar(Long id);

    Optional<Marcas> getById(Long id);
}
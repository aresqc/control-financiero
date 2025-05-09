package com.example.demo.services.impl;

import com.example.demo.models.Ciudades;
import com.example.demo.repositories.CiudadesRepository;
import com.example.demo.services.CiudadesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CiudadesServiceImpl implements CiudadesService {

    private final CiudadesRepository repository;

    @Override
    public List<Ciudades> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Ciudades> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Ciudades ciudad) {
        repository.save(ciudad);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
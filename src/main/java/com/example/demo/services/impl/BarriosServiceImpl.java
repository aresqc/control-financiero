package com.example.demo.services.impl;

import com.example.demo.models.Barrios;
import com.example.demo.repositories.BarriosRepository;
import com.example.demo.services.BarriosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarriosServiceImpl implements BarriosService {

    private final BarriosRepository repository;

    @Override
    public List<Barrios> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Barrios> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Barrios barrio) {
        repository.save(barrio);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
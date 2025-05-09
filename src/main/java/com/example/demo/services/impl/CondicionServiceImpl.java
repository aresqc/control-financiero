package com.example.demo.services.impl;

import com.example.demo.models.Condicion;
import com.example.demo.repositories.CondicionRepository;
import com.example.demo.services.CondicionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CondicionServiceImpl implements CondicionService {

    private final CondicionRepository repository;

    @Override
    public List<Condicion> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Condicion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Condicion condicion) {
        repository.save(condicion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
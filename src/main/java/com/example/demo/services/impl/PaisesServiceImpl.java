package com.example.demo.services.impl;

import com.example.demo.models.Paises;
import com.example.demo.repositories.PaisesRepository;
import com.example.demo.services.PaisesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaisesServiceImpl implements PaisesService {

    private final PaisesRepository repository;

    @Override
    public List<Paises> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Paises> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Paises pais) {
        repository.save(pais);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
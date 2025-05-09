package com.example.demo.services.impl;

import com.example.demo.models.Timbrados;
import com.example.demo.repositories.TimbradosRepository;
import com.example.demo.services.TimbradosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TimbradosServiceImpl implements TimbradosService {

    private final TimbradosRepository repository;

    @Override
    public List<Timbrados> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Timbrados> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Timbrados timbrado) {
        repository.save(timbrado);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
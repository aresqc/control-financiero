package com.example.demo.services.impl;

import com.example.demo.models.Cobros;
import com.example.demo.repositories.CobrosRepository;
import com.example.demo.services.CobrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CobrosServiceImpl implements CobrosService {

    @Autowired
    private CobrosRepository repository;

    @Override
    public List<Cobros> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Cobros guardar(Cobros cobro) {
        return repository.save(cobro);
    }

    @Override
    public Cobros buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
package com.example.demo.services.impl;

import com.example.demo.models.Cajas;
import com.example.demo.repositories.CajasRepository;
import com.example.demo.services.CajasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajasServiceImpl implements CajasService {

    @Autowired
    private CajasRepository repository;

    @Override
    public List<Cajas> getAlls() {
        return repository.findAll();
    }

    @Override
    public Optional<Cajas> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Cajas caja) {
        repository.save(caja);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Cajas> listarTodos() {
        return repository.findAll();
    }
}
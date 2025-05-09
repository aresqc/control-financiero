package com.example.demo.services.impl;

import com.example.demo.models.Compras;
import com.example.demo.repositories.ComprasRepository;
import com.example.demo.services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprasServiceImpl implements ComprasService {

    @Autowired
    private ComprasRepository repository;

    @Override
    public List<Compras> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Compras guardar(Compras compra) {
        return repository.save(compra);
    }

    @Override
    public Compras buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
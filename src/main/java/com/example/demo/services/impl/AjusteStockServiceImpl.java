package com.example.demo.services.impl;

import com.example.demo.models.AjusteStock;
import com.example.demo.repositories.AjusteStockRepository;
import com.example.demo.services.AjusteStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AjusteStockServiceImpl implements AjusteStockService {

    @Autowired
    private AjusteStockRepository repository;

    @Override
    public List<AjusteStock> listarTodos() {
        return repository.findAll();
    }

    @Override
    public AjusteStock guardar(AjusteStock ajuste) {
        return repository.save(ajuste);
    }

    @Override
    public AjusteStock buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
package com.example.demo.services.impl;

import com.example.demo.models.Nota_CreditoCompras;
import com.example.demo.repositories.Nota_CreditoComprasRepository;
import com.example.demo.services.Nota_CreditoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Nota_CreditoComprasServiceImpl implements Nota_CreditoComprasService {

    @Autowired
    private Nota_CreditoComprasRepository repository;

    @Override
    public List<Nota_CreditoCompras> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Nota_CreditoCompras guardar(Nota_CreditoCompras nota) {
        return repository.save(nota);
    }

    @Override
    public Nota_CreditoCompras buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
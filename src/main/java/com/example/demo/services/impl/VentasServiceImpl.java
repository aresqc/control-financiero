package com.example.demo.services.impl;

import com.example.demo.models.Ventas;
import com.example.demo.repositories.VentasRepository;
import com.example.demo.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {

    @Autowired
    private VentasRepository repository;

    @Override
    public List<Ventas> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Ventas guardar(Ventas venta) {
        return repository.save(venta);
    }

    @Override
    public Ventas buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
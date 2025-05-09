package com.example.demo.services.impl;

import com.example.demo.models.OrdenCompra;
import com.example.demo.repositories.OrdenCompraRepository;
import com.example.demo.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository repository;

    @Override
    public List<OrdenCompra> listarTodos() {
        return repository.findAll();
    }

    @Override
    public OrdenCompra guardar(OrdenCompra orden) {
        return repository.save(orden);
    }

    @Override
    public OrdenCompra buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

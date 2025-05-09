package com.example.demo.services.impl;

import com.example.demo.models.PedidoVentas;
import com.example.demo.repositories.PedidoVentasRepository;
import com.example.demo.services.PedidoVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoVentasServiceImpl implements PedidoVentasService {

    @Autowired
    private PedidoVentasRepository repository;

    @Override
    public List<PedidoVentas> listarTodos() {
        return repository.findAll();
    }

    @Override
    public PedidoVentas guardar(PedidoVentas pedido) {
        return repository.save(pedido);
    }

    @Override
    public PedidoVentas buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
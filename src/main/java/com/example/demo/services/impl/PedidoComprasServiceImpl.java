package com.example.demo.services.impl;

import com.example.demo.models.PedidoCompras;
import com.example.demo.repositories.PedidoComprasRepository;
import com.example.demo.services.PedidoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoComprasServiceImpl implements PedidoComprasService {

    @Autowired
    private PedidoComprasRepository repository;

    @Override
    public List<PedidoCompras> listarTodos() {
        return repository.findAll();
    }

    @Override
    public PedidoCompras guardar(PedidoCompras pedido) {
        return repository.save(pedido);
    }

    @Override
    public PedidoCompras buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

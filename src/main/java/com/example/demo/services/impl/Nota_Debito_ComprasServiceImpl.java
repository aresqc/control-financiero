package com.example.demo.services.impl;

import com.example.demo.models.Nota_Debito_Compras;
import com.example.demo.repositories.Nota_Debito_ComprasRepository;
import com.example.demo.services.Nota_Debito_ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Nota_Debito_ComprasServiceImpl implements Nota_Debito_ComprasService {

    @Autowired
    private Nota_Debito_ComprasRepository repository;

    @Override
    public List<Nota_Debito_Compras> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Nota_Debito_Compras guardar(Nota_Debito_Compras nota) {
        return repository.save(nota);
    }

    @Override
    public Nota_Debito_Compras buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
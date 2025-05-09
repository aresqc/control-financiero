package com.example.demo.services.impl;

import com.example.demo.models.AperturaCierre;
import com.example.demo.repositories.AperturaCierreRepository;
import com.example.demo.services.AperturaCierreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AperturaCierreServiceImpl implements AperturaCierreService {

    @Autowired
    private AperturaCierreRepository repository;

    @Override
    public List<AperturaCierre> listarTodos() {
        return repository.findAll();
    }

    @Override
    public AperturaCierre guardar(AperturaCierre apertura) {
        return repository.save(apertura);
    }

    @Override
    public AperturaCierre buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
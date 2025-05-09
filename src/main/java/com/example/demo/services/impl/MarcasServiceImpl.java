package com.example.demo.services.impl;

import com.example.demo.models.Marcas;
import com.example.demo.repositories.MarcasRepository;
import com.example.demo.services.MarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcasServiceImpl implements MarcasService {

    @Autowired
    private MarcasRepository marcasRepository;

    @Override
    public List<Marcas> listar() {
        return marcasRepository.findAll();
    }

    @Override
    public Marcas guardar(Marcas marca) {
        return marcasRepository.save(marca);
    }

    @Override
    public void eliminar(Long id) {
        marcasRepository.deleteById(id);
    }

    @Override
    public Optional<Marcas> getById(Long id) {
        return marcasRepository.findById(id);
    }
}
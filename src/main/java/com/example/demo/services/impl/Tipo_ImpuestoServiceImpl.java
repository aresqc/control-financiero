package com.example.demo.services.impl;

import com.example.demo.models.Tipo_Impuesto;
import com.example.demo.repositories.Tipo_ImpuestoRepository;
import com.example.demo.services.Tipo_ImpuestoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Tipo_ImpuestoServiceImpl implements Tipo_ImpuestoService {

    private final Tipo_ImpuestoRepository repository;

    @Override
    public List<Tipo_Impuesto> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Tipo_Impuesto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Tipo_Impuesto tipo) {
        repository.save(tipo);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
package com.example.demo.services.impl;

import com.example.demo.models.Empleados;
import com.example.demo.repositories.EmpleadosRepository;
import com.example.demo.services.EmpleadosService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmpleadosServiceImpl implements EmpleadosService {

    private final EmpleadosRepository repository;

    @Override
    public List<Empleados> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Empleados> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Empleados empleado) {
        repository.save(empleado);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
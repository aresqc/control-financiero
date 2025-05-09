package com.example.demo.services.impl;

import com.example.demo.models.Proveedores;
import com.example.demo.repositories.ProveedoresRepository;
import com.example.demo.services.ProveedoresService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProveedoresServiceImpl implements ProveedoresService {

    private final ProveedoresRepository repository;

    @Override
    public List<Proveedores> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Proveedores> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Proveedores proveedor) {
        repository.save(proveedor);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
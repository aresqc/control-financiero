package com.example.demo.services.impl;

import com.example.demo.models.Clientes;
import com.example.demo.repositories.ClientesRepository;
import com.example.demo.services.ClientesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {

    private final ClientesRepository repository;

    @Override
    public List<Clientes> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Clientes> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public void guardar(Clientes cliente) {
        repository.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
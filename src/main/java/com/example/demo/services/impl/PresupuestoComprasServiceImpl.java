package com.example.demo.services.impl;

import com.example.demo.models.PresupuestoCompras;
import com.example.demo.repositories.PresupuestoComprasRepository;
import com.example.demo.services.PresupuestoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresupuestoComprasServiceImpl implements PresupuestoComprasService {

    @Autowired
    private PresupuestoComprasRepository repository;

    @Override
    public List<PresupuestoCompras> listarTodos() {
        return repository.findAll();
    }

    @Override
    public PresupuestoCompras guardar(PresupuestoCompras presupuesto) {
        return repository.save(presupuesto);
    }

    @Override
    public PresupuestoCompras buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}

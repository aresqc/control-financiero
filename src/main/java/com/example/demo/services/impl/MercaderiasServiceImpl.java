package com.example.demo.services.impl;

import com.example.demo.models.Mercaderias;
import com.example.demo.repositories.MercaderiasRepository;
import com.example.demo.services.MercaderiasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MercaderiasServiceImpl implements MercaderiasService {

    private final MercaderiasRepository repository;

    @Override
    public List<Mercaderias> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Mercaderias> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mercaderias guardar(Mercaderias mercaderia) {
        return repository.save(mercaderia);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

	@Override
	public Optional<Mercaderias> getById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
package com.example.demo.services;

import com.example.demo.models.Marcas;
import com.example.demo.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marcas> listar() {
        return marcaRepository.findAll();
    }

    public Marcas guardar(Marcas marca) {
        return marcaRepository.save(marca);
    }

    public void eliminar(Long id) {
        marcaRepository.deleteById(id);
    }

	public Optional<Marcas> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
package com.example.demo.services;

import com.example.demo.models.Bancos;
import com.example.demo.repositories.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Bancos> listar() {
        return bancoRepository.findAll();
    }

    public Bancos guardar(Bancos banco) {
        return bancoRepository.save(banco);
    }

    public void eliminar(Long id) {
        bancoRepository.deleteById(id);
    }

	public Optional<Bancos> getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
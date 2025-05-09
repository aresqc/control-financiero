package com.example.demo.services.impl;

import com.example.demo.models.Roles;
import com.example.demo.repositories.RolesRepository;
import com.example.demo.services.RolesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;

    @Override
    public List<Roles> listarTodos() {
        return (List<Roles>) rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> buscarPorId(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public void guardar(Roles rol) {
        if (rol != null) {
            rolesRepository.save(rol);
        }
    }

    @Override
    public void eliminar(Long id) {
        rolesRepository.findById(id).ifPresent(rolesRepository::delete);
    }

	@Override
	public Object getAllRoles() {
		return null;
	}

	@Override
	public void saveRoles(Roles rol) {
		
	}

	@Override
	public Optional<Roles> getRolById(Long id) {
			return Optional.empty();
	}

	@Override
	public void deleteRol(Long id) {
	}
}
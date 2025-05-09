package com.example.demo.services;

import com.example.demo.models.Roles;
import java.util.List;
import java.util.Optional;

public interface RolesService {
    List<Roles> listarTodos();
    Optional<Roles> buscarPorId(Long id);
    void guardar(Roles rol);
    void eliminar(Long id);
	Object getAllRoles();
	void saveRoles(Roles rol);
	Optional<Roles> getRolById(Long id);
	void deleteRol(Long id);
}
package com.example.demo.services.impl;

import com.example.demo.models.Usuarios;
import com.example.demo.repositories.UsuariosRepository;
import com.example.demo.services.UsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuariosServiceImpl implements UserDetailsService, UsuariosService {

    private final UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getAlias());

        return User.withUsername(usuario.getUsername())
                .password(usuario.getContrasena())
                .authorities(List.of(authority))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!usuario.isEstado())
                .build();
    }

    @Override
    public List<Usuarios> listarTodos() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> buscarPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public void guardar(Usuarios usuario) {
        usuariosRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuariosRepository.findById(id).ifPresent(usuariosRepository::delete);
    }
}
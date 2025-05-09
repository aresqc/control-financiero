package com.example.demo.repositories;

import com.example.demo.models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
}
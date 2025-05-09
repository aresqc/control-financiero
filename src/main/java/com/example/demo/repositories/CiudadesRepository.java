package com.example.demo.repositories;

import com.example.demo.models.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadesRepository extends JpaRepository<Ciudades, Long> {
}
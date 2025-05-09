package com.example.demo.repositories;

import com.example.demo.models.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcasRepository extends JpaRepository<Marcas, Long> {
}
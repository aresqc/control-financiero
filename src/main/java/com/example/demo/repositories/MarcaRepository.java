package com.example.demo.repositories;

import com.example.demo.models.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marcas, Long> {
}
package com.example.demo.repositories;

import com.example.demo.models.Paises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisesRepository extends JpaRepository<Paises, Long> {
}
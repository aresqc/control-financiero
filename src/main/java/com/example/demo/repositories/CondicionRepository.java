package com.example.demo.repositories;

import com.example.demo.models.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionRepository extends JpaRepository<Condicion, Long> {
}
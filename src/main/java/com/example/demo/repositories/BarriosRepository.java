package com.example.demo.repositories;

import com.example.demo.models.Barrios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarriosRepository extends JpaRepository<Barrios, Long> {
}
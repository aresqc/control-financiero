package com.example.demo.repositories;

import com.example.demo.models.Cajas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CajasRepository extends JpaRepository<Cajas, Long> {
}
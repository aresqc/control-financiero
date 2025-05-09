package com.example.demo.repositories;

import com.example.demo.models.Compras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Integer> {
}
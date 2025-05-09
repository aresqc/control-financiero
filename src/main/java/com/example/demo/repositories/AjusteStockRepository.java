package com.example.demo.repositories;

import com.example.demo.models.AjusteStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AjusteStockRepository extends JpaRepository<AjusteStock, Integer> {
}
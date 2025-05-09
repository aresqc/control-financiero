package com.example.demo.repositories;

import com.example.demo.models.Bancos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancosRepository extends JpaRepository<Bancos, Long> {
}
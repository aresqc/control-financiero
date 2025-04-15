package com.example.demo.repositories;

import com.example.demo.models.Bancos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Bancos, Long> {
}
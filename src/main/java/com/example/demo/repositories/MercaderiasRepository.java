package com.example.demo.repositories;

import com.example.demo.models.Mercaderias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MercaderiasRepository extends JpaRepository<Mercaderias, Long> {
}
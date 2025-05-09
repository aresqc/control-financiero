package com.example.demo.repositories;

import com.example.demo.models.PresupuestoCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresupuestoComprasRepository extends JpaRepository<PresupuestoCompras, Integer> {
}
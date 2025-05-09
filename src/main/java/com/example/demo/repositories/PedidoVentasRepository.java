package com.example.demo.repositories;

import com.example.demo.models.PedidoVentas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoVentasRepository extends JpaRepository<PedidoVentas, Integer> {
}
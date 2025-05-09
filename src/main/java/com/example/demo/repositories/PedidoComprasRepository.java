package com.example.demo.repositories;

import com.example.demo.models.PedidoCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoComprasRepository extends JpaRepository<PedidoCompras, Integer> {
}
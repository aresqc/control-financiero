package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ajuste_stock")
@Data
public class AjusteStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ajuste")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_mercaderia")
    private Mercaderias mercaderia;

    private Integer cantidad;

    @Column(name = "precio_compra")
    private Integer precioCompra;
}

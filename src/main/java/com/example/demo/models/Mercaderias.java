package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "mercaderias")
@Data
public class Mercaderias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mercaderia")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @NotNull
    private Marcas marca;

    @Size(max = 255)
    @Column(length = 255, name = "id_procedencia")
    private String procedencia;

    @Size(max = 100)
    @Column(length = 100)
    @NotNull
    private String descripcion;

    @Size(max = 1)
    @Column(length = 1)
    @NotNull
    private String afectaExistencia;

    @Size(max = 12)
    @Column(length = 12)
    @NotNull
    private String precioCompra;

    @Size(max = 12)
    @Column(length = 12)
    @NotNull
    private String precioVenta;
}


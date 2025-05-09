package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_barrio")
    @NotNull
    private Barrios barrio;

    @Size(max = 100)
    @Column(length = 100)
    @NotNull
    private String razon_social;

    @Size(max = 20)
    @Column(length = 20)
    @NotNull
    private String ruc;

    @Size(max = 100)
    @Column(length = 100)
    @NotNull
    private String direccion;

    @Size(max = 20)
    @Column(length = 20)
    @NotNull
    private String telefono;

    @Size(max = 50)
    @Column(length = 50)
    @NotNull
    private String email;

    @Size(max = 3)
    @Column(length = 3)
    private String tipo_persona;
}

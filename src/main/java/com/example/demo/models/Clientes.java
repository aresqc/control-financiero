package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Size(max = 100)
    @Column(length = 100)
    private String razon_social;

    @NotNull
    @Size(max = 20)
    @Column(length = 20)
    private String ruc;

    @Size(max = 100)
    @Column(length = 100)
    private String direccion;

    @Size(max = 20)
    @Column(length = 20)
    private String telefono;

    @Size(max = 50)
    @Column(length = 50)
    private String email;

    @Size(max = 3)
    @Column(length = 3)
    private String tipo_cliente;
}

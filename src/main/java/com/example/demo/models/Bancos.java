package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "bancos")
@Data
public class Bancos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_banco")
    private Long id;

    @Size(max = 50)
    @Column(length = 50)
    private String descripcion;

    @Size(max = 15)
    @Column(length = 15)
    private String telefono;

    @Size(max = 200)
    @Column(length = 200)
    private String direccion;

    @Size(max = 255)
    @Column(length = 255)
    private String nombre;
}

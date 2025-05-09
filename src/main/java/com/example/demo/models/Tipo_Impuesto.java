package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "tipo_impuesto")
@Data
public class Tipo_Impuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_impuesto")
    private Long id;

    @Size(max = 80)
    @Column(length = 80)
    private String descripcion;

    @Size(max = 255)
    @Column(length = 255)
    private String tipo;

    @Size(max = 50)
    @Column(length = 50)
    private String email;
}

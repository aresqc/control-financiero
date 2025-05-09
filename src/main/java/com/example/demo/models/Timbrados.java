package com.example.demo.models;

import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "timbrados")
@Data
public class Timbrados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_timbrado")
    private Long id;

    @NotNull
    private Integer nro_desde;

    @NotNull
    private Integer nro_hasta;

    private Integer nro1;

    private Integer nro2;

    private Integer nro3;

    @NotNull
    private Date fecha_inicio;

    @NotNull
    private Date fecha_fin;

    @Column(name = "id_tipo_documento")
    private Integer id_tipo_documento;

    @Column(length = 3)
    private String estado;
}

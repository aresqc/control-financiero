package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "apertura_cierre")
@Data
public class AperturaCierre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apertura_cierre")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Cajas caja;

    private LocalDate fechaApertura;

    private LocalTime horaApertura;

    private Integer montoApertura;

    @ManyToOne
    @JoinColumn(name = "id_usuario_apertura")
    private Usuarios usuarioApertura;

    private LocalDate fechaCierre;

    private LocalTime horaCierre;

    private Integer montoCierre;

    @Column(length = 3)
    private String estado;

    @Column(name = "monto_efectivo", precision = 12, scale = 2)
    private BigDecimal montoEfectivo;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_usuario_cierre")
    private Usuarios usuarioCierre;
}
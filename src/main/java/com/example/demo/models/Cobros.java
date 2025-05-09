package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "cobros")
@Data
public class Cobros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cobro")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Ventas venta;

    @ManyToOne
    @JoinColumn(name = "id_banco")
    private Bancos banco;

    @Column(length = 50)
    private String bancoNombre;

    @Column(name = "nro_comprobante", length = 30)
    private String nroComprobante;

    @Column(name = "fecha_cobro_cheque")
    private LocalDate fechaCobroCheque;

    private Integer monto;

    private Integer tc;

    @Column(length = 20)
    private String seleccionado;

    @ManyToOne
    @JoinColumn(name = "id_apertura_cierre")
    private AperturaCierre aperturaCierre;

    @Column(name = "fecha_cheque")
    private LocalDate fechaCheque;
}
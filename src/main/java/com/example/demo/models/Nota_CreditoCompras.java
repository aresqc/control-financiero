package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "nota_credito_compras")
@Data
public class Nota_CreditoCompras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_credito_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compras compra;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedores proveedor;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @Column(length = 200)
    private String observacion;

    private LocalDate fecha;

    @Column(length = 1)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;

    @Column(name = "nro_nota_credito", length = 15)
    private String nroNotaCredito;

    @Column(name = "nro_timbrado", length = 10)
    private String nroTimbrado;
}


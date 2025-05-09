package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "orden_compra")
@Data
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_presupuesto_compra")
    private PresupuestoCompras presupuesto;

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
}

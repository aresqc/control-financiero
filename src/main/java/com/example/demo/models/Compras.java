package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "compras")
@Data
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra")
    private OrdenCompra ordenCompra;

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

    @Column(name = "nro_factura", length = 15)
    private String nroFactura;

    @Column(name = "nro_timbrado", length = 10)
    private String nroTimbrado;

    @ManyToOne
    @JoinColumn(name = "id_nota_credito")
    private Nota_CreditoCompras notaCredito;

    @ManyToOne
    @JoinColumn(name = "id_nota_debito")
    private Nota_Debito_Compras notaDebito;
}


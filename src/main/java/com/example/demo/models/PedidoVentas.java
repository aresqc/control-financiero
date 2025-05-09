package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "pedido_ventas")
@Data
public class PedidoVentas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido_venta")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @Column(length = 200)
    private String observacion;

    private LocalDate fecha;

    @Column(length = 1)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;
}
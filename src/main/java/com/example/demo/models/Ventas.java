package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "ventas")
@Data
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_timbrado")
    private Timbrados timbrado;

    @ManyToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursal;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados empleado;

    @ManyToOne
    @JoinColumn(name = "id_pedido_venta")
    private PedidoVentas pedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    private LocalDate fecha;

    @Column(length = 3)
    private String estado;

    private Integer nro1;
    private Integer nro2;
    private Integer nro3;

    @ManyToOne
    @JoinColumn(name = "id_condicion")
    private Condicion condicion;

    @ManyToOne
    @JoinColumn(name = "id_nota_credito")
    private Nota_CreditoCompras notaCredito;

    @ManyToOne
    @JoinColumn(name = "id_nota_debito")
    private Nota_Debito_Compras notaDebito;

    @Column(length = 1)
    private String proceso;
}
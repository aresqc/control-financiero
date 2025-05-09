package com.example.demo.models;

import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "empleados")
@Data
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_barrio")
    @NotNull
    private Barrios barrio;

    @ManyToOne
    @JoinColumn(name = "id_nacionalidad")
    @NotNull
    private Paises nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @NotNull
    private Usuarios usuario;

    @Size(max = 50)
    @NotNull
    private String nombres;

    @Size(max = 50)
    @NotNull
    private String apellidos;

    @Size(max = 20)
    @NotNull
    private String cedula_identidad;

    @NotNull
    @Column(name = "fecha_nac")
    private Date fechaNacimiento;

    @Size(max = 20)
    @NotNull
    private String sexo;

    @Size(max = 20)
    @NotNull
    private String estado;

    @NotNull
    @Column(name = "fecha_incorporacion")
    private Date fechaIncorporacion;

    @Size(max = 100)
    private String direccion;

    @Size(max = 20)
    private String telefono;

    @Size(max = 50)
    private String email;
}
package com.hispana.clientevehiculo_servicio.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;

    @Column(length = 10, nullable = false)
    public String identificacion;

    @Column(length = 50, nullable = false)
    public String nombres;

    @Column(length = 50, nullable = false)
    public String apellidos;

    @Column(length = 100, nullable = true)
    public String nombreCorto;

    @Column(length = 50, nullable = false)
    public String direccion;

    @Column(length = 50, nullable = false)
    public String correo;

    @Column(length = 10, nullable = false)
    public String telefono;

    @ManyToMany
    @JoinTable(name= "clientes_vehiculos",joinColumns = @JoinColumn(name= "cliente_id"), inverseJoinColumns = @JoinColumn(name = "vehiculo_id"))
    public Set<Vehiculo> vehiculos = new HashSet<>();
}

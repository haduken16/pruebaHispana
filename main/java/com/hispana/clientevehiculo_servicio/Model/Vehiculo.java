package com.hispana.clientevehiculo_servicio.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10, nullable = false, unique = true)
    public String placa;

    @OneToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;

    @Column(length = 10, nullable = false, unique = true)
    public String chasis;
}

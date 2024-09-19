package com.hispana.clientevehiculo_servicio.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    public String descripcion;

    @OneToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;
}

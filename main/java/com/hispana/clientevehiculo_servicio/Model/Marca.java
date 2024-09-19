package com.hispana.clientevehiculo_servicio.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    public String descripcion;

}

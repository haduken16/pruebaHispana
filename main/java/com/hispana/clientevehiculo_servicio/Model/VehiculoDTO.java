package com.hispana.clientevehiculo_servicio.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehiculoDTO {
    private int id;

    @NotNull(message = "La placa no puede ser nula")
    @NotBlank(message = "El campo placa no puede estar vacío")
    public String placa;

    private ModeloDTO modelo;

    @NotNull(message = "El chasis no puede ser nulo")
    @NotBlank(message = "El campo chasis no puede estar vacío")
    public String chasis;

    public VehiculoDTO() {

    }
}

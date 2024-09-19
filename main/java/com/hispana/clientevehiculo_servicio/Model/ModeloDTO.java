package com.hispana.clientevehiculo_servicio.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModeloDTO {
    private int id;

    @NotNull(message = "La descripción del modelo no puede ser nula")
    @NotBlank(message = "El campo descripción de modelo no puede estar vacío")
    public String descripcion;

    private MarcaDTO marca;

    public ModeloDTO() {

    }
}

package com.hispana.clientevehiculo_servicio.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarcaDTO {
    private int id;

    @NotNull(message = "La descripción de la marca no puede ser nula")
    @NotBlank(message = "El campo descripción de marca no puede estar vacío")
    public String descripcion;

    public MarcaDTO() {

    }
}

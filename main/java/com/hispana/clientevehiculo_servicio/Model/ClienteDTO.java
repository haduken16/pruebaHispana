package com.hispana.clientevehiculo_servicio.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
public class ClienteDTO {
    @NotNull(message = "La identificación no puede ser nula")
    @NotBlank(message = "La identificación no puede estar vacía")
    public String identificacion;

    @NotNull(message = "El nombre/Los nombres no pueden ser nulos")
    @NotBlank(message = "El campo nombres no puede estar vacío")
    public String nombres;

    @NotNull(message = "El apellido/Los apellidos no pueden ser nulos")
    @NotBlank(message = "El campo apellidos no puede estar vacío")
    public String apellidos;

    @NotNull(message = "La dirección no puede ser nula")
    @NotBlank(message = "El campo dirección no puede estar vacío")
    public String direccion;

    @NotNull(message = "El correo no puede ser nulo")
    @NotBlank(message = "El campo correo no puede estar vacío")
    @Email(message = "Ingrese un correo electrónico válido")
    public String correo;

    @NotNull(message = "El teléfono no puede ser nulo")
    @NotBlank(message = "El campo teléfono no puede estar vacío")
    public String telefono;

    public Set<Vehiculo> vehiculos = new HashSet<>();

    public ClienteDTO() {

    }
}

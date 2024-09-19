package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Error.ValidacionesExceptions;
import com.hispana.clientevehiculo_servicio.Model.ClienteDTO;

import java.util.List;

public interface ClienteServicio {
    List<ClienteDTO> listarClientes(String identificacion);

    ClienteDTO guardarCliente(ClienteDTO cliente) throws ValidacionesExceptions;
}

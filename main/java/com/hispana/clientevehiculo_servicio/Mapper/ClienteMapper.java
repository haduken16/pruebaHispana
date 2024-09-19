package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Cliente;
import com.hispana.clientevehiculo_servicio.Model.ClienteDTO;

import java.util.List;

public interface ClienteMapper {
    Cliente toCliente(ClienteDTO clienteDTO);
    ClienteDTO toClienteDTO(Cliente cliente);
    List<ClienteDTO> toClienteDTOs(List<Cliente> clientes);
}

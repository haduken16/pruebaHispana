package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Cliente;
import com.hispana.clientevehiculo_servicio.Model.ClienteDTO;
import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import com.hispana.clientevehiculo_servicio.Model.VehiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapperImpl implements ClienteMapper {
    @Autowired
    private VehiculoMapper vehiculoMapper;

    @Override
    public Cliente toCliente(ClienteDTO clienteDTO) {
        if(clienteDTO == null)
            return null;

        Cliente cliente = new Cliente();
        cliente.setIdentificacion(clienteDTO.getIdentificacion());
        cliente.setNombres(clienteDTO.getNombres());
        cliente.setApellidos(clienteDTO.getApellidos());
        cliente.setNombreCorto(clienteDTO.getNombres() + " " + clienteDTO.getApellidos());
        cliente.setDireccion(clienteDTO.getDireccion());
        cliente.setCorreo(clienteDTO.getCorreo());
        cliente.setTelefono(clienteDTO.getTelefono());

        cliente.setVehiculos(clienteDTO.getVehiculos());
        return cliente;
    }

    @Override
    public ClienteDTO toClienteDTO(Cliente cliente) {
        if(cliente == null)
            return null;

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdentificacion(cliente.getIdentificacion());
        clienteDTO.setNombres(cliente.getNombres());
        clienteDTO.setApellidos(cliente.getApellidos());
        clienteDTO.setDireccion(cliente.getDireccion());
        clienteDTO.setCorreo(cliente.getCorreo());
        clienteDTO.setTelefono(cliente.getTelefono());
        //clienteDTO.setVehiculos(vehiculoMapper.toVehiculoDTOs(cliente.getVehiculos()));
        clienteDTO.setVehiculos(cliente.getVehiculos());

        return clienteDTO;
    }

    @Override
    public List<ClienteDTO> toClienteDTOs(List<Cliente> clientes) {
        if(clientes == null)
            return null;

        List<ClienteDTO> lista = new ArrayList<ClienteDTO>(clientes.size());
        for(Cliente cliente : clientes){
            lista.add(toClienteDTO(cliente));
        }

        return lista;
    }
}

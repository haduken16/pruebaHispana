package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Error.ValidacionesExceptions;
import com.hispana.clientevehiculo_servicio.Mapper.*;
import com.hispana.clientevehiculo_servicio.Model.*;
import com.hispana.clientevehiculo_servicio.Repository.ClienteRepository;
import com.hispana.clientevehiculo_servicio.Repository.MarcaRepository;
import com.hispana.clientevehiculo_servicio.Repository.ModeloRepository;
import com.hispana.clientevehiculo_servicio.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private VehiculoMapper vehiculoMapper;
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private MarcaServicio marcaServicio;
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaMapper marcaMapper;
    @Autowired
    private ModeloServicio modeloServicio;
    @Autowired
    private ModeloMapper modeloMapper;
    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public List<ClienteDTO> listarClientes(String identificacion) {
        List<Cliente> clientes = clienteRepository.findByIdentificacion(identificacion);
        return clienteMapper.toClienteDTOs(clientes);
    }

    @Override
    public ClienteDTO guardarCliente(ClienteDTO cliente) throws ValidacionesExceptions {
        Cliente clienteEntidad = clienteMapper.toCliente(cliente);

        if(clienteEntidad.getVehiculos() != null) {
            for(Vehiculo lista : cliente.getVehiculos()){
                VehiculoDTO vehiculoDTO = new VehiculoDTO();

                if(vehiculoRepository.existsByChasis(lista.getChasis())){
                    throw new ValidacionesExceptions("El Chasis ya existe");
                }

                if(vehiculoRepository.existsByPlaca(lista.getPlaca())){
                    throw new ValidacionesExceptions("La placa ya existe");
                }

                if(lista.getId() == 0){
                    vehiculoDTO.setPlaca(lista.getPlaca());
                    vehiculoDTO.setChasis(lista.getChasis());

                    MarcaDTO marcaDTO = new MarcaDTO();
                    marcaDTO.setDescripcion(lista.getModelo().getMarca().getDescripcion());
                    marcaServicio.guardarMarca(marcaDTO);

                    ModeloDTO modeloDTO = new ModeloDTO();
                    modeloDTO.setDescripcion(lista.getModelo().getDescripcion());
                    modeloDTO.setMarca(marcaMapper.toMarcaDTO(marcaRepository.findByDescripcion(lista.getModelo().getMarca().getDescripcion())));
                    modeloServicio.guardarModelo(modeloDTO);

                    vehiculoDTO.setModelo(modeloMapper.toModeloDTO(modeloRepository.findByDescripcion(lista.getModelo().getDescripcion())));
                    vehiculoRepository.save(vehiculoMapper.toVehiculo(vehiculoDTO));

                    lista.setId(vehiculoRepository.findByPlaca(vehiculoDTO.getPlaca()).getId());
                }
            }
        }


        return clienteMapper.toClienteDTO(clienteRepository.save(clienteEntidad));

    }


}

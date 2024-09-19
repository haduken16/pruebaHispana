package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.*;
import com.hispana.clientevehiculo_servicio.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoMapperImpl implements VehiculoMapper {
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaMapper marcaMapper;

    @Override
    public Vehiculo toVehiculo(VehiculoDTO vehiculoDTO) {
        if(vehiculoDTO==null)
            return null;

        Vehiculo vehiculo = new Vehiculo();
        Modelo modelo = new Modelo();

        vehiculo.setPlaca(vehiculoDTO.getPlaca());
        modelo.setId(vehiculoDTO.getModelo().getId());
        vehiculo.setModelo(modelo);
        vehiculo.setChasis(vehiculoDTO.getChasis());

        if(vehiculoDTO.getModelo().getMarca() != null){
            Marca marca = new Marca();
            marca.setId(vehiculoDTO.getModelo().getMarca().getId());
            marca.setDescripcion(vehiculoDTO.getModelo().getMarca().getDescripcion());
        }

        return vehiculo;
    }

    @Override
    public VehiculoDTO toVehiculoDTO(Vehiculo vehiculo) {
        if(vehiculo==null)
            return null;

        VehiculoDTO vehiculoDTO = new VehiculoDTO();
        ModeloDTO modeloDTO = new ModeloDTO();
        //MarcaDTO marcaDTO = new MarcaDTO();

        vehiculoDTO.setPlaca(vehiculo.getPlaca());
        //marcaDTO.setId(vehiculo.getModelo().getMarca().getId());
        //marcaDTO.setDescripcion(vehiculo.getModelo().getMarca().getDescripcion());
        modeloDTO.setId(vehiculo.getModelo().getId());
        //modeloDTO.setMarca(marcaMapper.toMarcaDTO(marcaRepository.findById(vehiculo.getModelo().getMarca().getId())));
        modeloDTO.setDescripcion(vehiculo.getModelo().getDescripcion());
        vehiculoDTO.setModelo(modeloDTO);
        vehiculoDTO.setChasis(vehiculo.getChasis());

        return vehiculoDTO;
    }

    @Override
    public List<VehiculoDTO> toVehiculoDTOs(List<Vehiculo> vehiculos) {
        if(vehiculos==null)
            return null;

        List<VehiculoDTO> lista = new ArrayList<VehiculoDTO>(vehiculos.size());
        for(Vehiculo vehiculo : vehiculos){
            lista.add(toVehiculoDTO(vehiculo));
        }

        return lista;

    }
}

package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Mapper.MarcaMapper;
import com.hispana.clientevehiculo_servicio.Mapper.VehiculoMapper;
import com.hispana.clientevehiculo_servicio.Model.*;
import com.hispana.clientevehiculo_servicio.Repository.MarcaRepository;
import com.hispana.clientevehiculo_servicio.Repository.ModeloRepository;
import com.hispana.clientevehiculo_servicio.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServicioImpl implements VehiculoServicio {
    @Autowired
    private VehiculoRepository vehiculoRepository;
    @Autowired
    private VehiculoMapper vehiculoMapper;
    @Autowired
    private ModeloServicio modeloServicio;
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private MarcaMapper marcaMapper;


    @Override
    public List<VehiculoDTO> listarVehiculos() {
        return vehiculoMapper.toVehiculoDTOs(vehiculoRepository.findAll());
    }

    @Override
    public VehiculoDTO guardarVehiculo(VehiculoDTO vehiculo) {

        if(vehiculo.getModelo().getId() == 0){
            vehiculo.setModelo(modeloServicio.guardarModelo(vehiculo.getModelo()));
            vehiculo.getModelo().setMarca(marcaMapper.toMarcaDTO(marcaRepository.findByDescripcion(vehiculo.getModelo().getMarca().getDescripcion())));
        }

        Vehiculo vehiculoEntidad = vehiculoMapper.toVehiculo(vehiculo);
        vehiculoEntidad.getModelo().setMarca(marcaRepository.findByDescripcion(vehiculo.getModelo().getMarca().getDescripcion()));
        return vehiculoMapper.toVehiculoDTO(vehiculoRepository.save(vehiculoEntidad));
    }

    @Override
    public boolean existeChasis(String chasis){
        return vehiculoRepository.existsByChasis(chasis);
    }
}

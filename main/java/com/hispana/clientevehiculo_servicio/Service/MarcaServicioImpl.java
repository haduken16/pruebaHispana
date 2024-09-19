package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Mapper.MarcaMapper;
import com.hispana.clientevehiculo_servicio.Model.Marca;
import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;
import com.hispana.clientevehiculo_servicio.Repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicioImpl implements MarcaServicio {
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private MarcaMapper marcaMapper;

    @Override
    public List<MarcaDTO> listarMarcas() {
        return marcaMapper.toMarcaDTOs(marcaRepository.findAll());
    }

    @Override
    public MarcaDTO guardarMarca(MarcaDTO marca) {
        Marca marcaEntidad = marcaMapper.toMarca(marca);
        return marcaMapper.toMarcaDTO(marcaRepository.save(marcaEntidad));
    }
}

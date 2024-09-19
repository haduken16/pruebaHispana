package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Mapper.ModeloMapper;
import com.hispana.clientevehiculo_servicio.Model.Marca;
import com.hispana.clientevehiculo_servicio.Model.Modelo;
import com.hispana.clientevehiculo_servicio.Model.ModeloDTO;
import com.hispana.clientevehiculo_servicio.Repository.MarcaRepository;
import com.hispana.clientevehiculo_servicio.Repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloServicioImpl implements ModeloServicio {
    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloMapper modeloMapper;

    @Override
    public List<ModeloDTO> listarModelos() {
        return modeloMapper.toModeloDTOs(modeloRepository.findAll());
    }

    @Override
    public ModeloDTO guardarModelo(ModeloDTO modelo) {
        Modelo modeloEntidad = modeloMapper.toModelo(modelo);
        Marca marcaEntidad = new Marca();

        if(modeloEntidad.getMarca() != null){
            if(modeloEntidad.getMarca().getId() == 0) {
                marcaEntidad.setDescripcion(modelo.getMarca().getDescripcion());
                marcaRepository.save(marcaEntidad);

                marcaEntidad = marcaRepository.findByDescripcion(marcaEntidad.getDescripcion());
                modeloEntidad.setMarca(marcaEntidad);
            }
        }

        return modeloMapper.toModeloDTO(modeloRepository.save(modeloEntidad));
    }
}

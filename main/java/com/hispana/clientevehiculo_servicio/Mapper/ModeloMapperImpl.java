package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Marca;
import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;
import com.hispana.clientevehiculo_servicio.Model.Modelo;
import com.hispana.clientevehiculo_servicio.Model.ModeloDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModeloMapperImpl implements ModeloMapper {
    @Override
    public Modelo toModelo(ModeloDTO modeloDto) {
        if(modeloDto == null)
            return null;

        Modelo modelo = new Modelo();
        Marca marca = new Marca();
        modelo.setId(modeloDto.getId());
        modelo.setDescripcion(modeloDto.getDescripcion());

        marca.setId(modeloDto.getMarca().getId());
        modelo.setMarca(marca);

        return modelo;
    }

    @Override
    public ModeloDTO toModeloDTO(Modelo modelo) {
        if(modelo == null)
            return null;

        ModeloDTO modeloDTO = new ModeloDTO();
        MarcaDTO marcaDTO = new MarcaDTO();

        modeloDTO.setId(modelo.getId());
        modeloDTO.setDescripcion(modelo.getDescripcion());

        marcaDTO.setId(modelo.getMarca().getId());
        marcaDTO.setDescripcion(modelo.getMarca().getDescripcion());
        modeloDTO.setMarca(marcaDTO);

        return modeloDTO;
    }

    @Override
    public List<ModeloDTO> toModeloDTOs(List<Modelo> modelos) {
        if(modelos == null)
            return null;

        List<ModeloDTO> lista = new ArrayList<>(modelos.size());
        for(Modelo modelo : modelos){
            lista.add(toModeloDTO(modelo));
        }

        return lista;
    }
}

package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Marca;
import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MarcaMapperImpl implements MarcaMapper {
    @Override
    public Marca toMarca(MarcaDTO marcaDTO) {
        if(marcaDTO == null)
            return null;

        Marca marca = new Marca();
        marca.setId(marcaDTO.getId());
        marca.setDescripcion(marcaDTO.getDescripcion());

        return marca;
    }

    @Override
    public MarcaDTO toMarcaDTO(Marca marca) {
        if(marca == null)
            return null;

        MarcaDTO marcaDTO = new MarcaDTO();
        marcaDTO.setId(marca.getId());
        marcaDTO.setDescripcion(marca.getDescripcion());

        return marcaDTO;
    }

    @Override
    public List<MarcaDTO> toMarcaDTOs(List<Marca> marcas) {
        if(marcas == null)
            return null;

        List<MarcaDTO> lista = new ArrayList<MarcaDTO>(marcas.size());
        for(Marca marca : marcas){
            lista.add(toMarcaDTO(marca));
        }
        return lista;
    }
}

package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Modelo;
import com.hispana.clientevehiculo_servicio.Model.ModeloDTO;

import java.util.List;

public interface ModeloMapper {
    Modelo toModelo(ModeloDTO modeloDto);
    ModeloDTO toModeloDTO(Modelo modelo);
    List<ModeloDTO> toModeloDTOs(List<Modelo> modelos);

}

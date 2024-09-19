package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Marca;
import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;

import java.util.List;

public interface MarcaMapper {
    Marca toMarca(MarcaDTO marcaDTO);
    MarcaDTO toMarcaDTO(Marca marca);
    List<MarcaDTO> toMarcaDTOs(List<Marca> marcas);
}

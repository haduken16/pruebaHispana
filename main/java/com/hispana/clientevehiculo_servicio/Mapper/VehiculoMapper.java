package com.hispana.clientevehiculo_servicio.Mapper;

import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import com.hispana.clientevehiculo_servicio.Model.VehiculoDTO;

import java.util.List;

public interface VehiculoMapper {
    Vehiculo toVehiculo(VehiculoDTO vehiculoDTO);
    VehiculoDTO toVehiculoDTO(Vehiculo vehiculo);
    List<VehiculoDTO> toVehiculoDTOs(List<Vehiculo> vehiculos);
}

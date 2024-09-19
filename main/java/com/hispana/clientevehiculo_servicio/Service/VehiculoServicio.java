package com.hispana.clientevehiculo_servicio.Service;

import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import com.hispana.clientevehiculo_servicio.Model.VehiculoDTO;

import java.util.List;

public interface VehiculoServicio {
    List<VehiculoDTO> listarVehiculos();
    VehiculoDTO guardarVehiculo(VehiculoDTO vehiculo);
    boolean existeChasis(String chasis);
}

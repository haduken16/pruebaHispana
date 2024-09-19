package com.hispana.clientevehiculo_servicio.Controller;

import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import com.hispana.clientevehiculo_servicio.Model.VehiculoDTO;
import com.hispana.clientevehiculo_servicio.Repository.VehiculoRepository;
import com.hispana.clientevehiculo_servicio.Service.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculoController {
    @Autowired
    private VehiculoServicio vehiculoServicio;

    @GetMapping("/vehiculo/find")
    public List<VehiculoDTO> ListarVehiculos(){

        return vehiculoServicio.listarVehiculos();
    }

    @PostMapping("/vehiculo/save")
    public String guardarVehiculo(@RequestBody VehiculoDTO vehiculo){
        vehiculoServicio.guardarVehiculo(vehiculo);
        return "vehiculo guardado";
    }

    @GetMapping("/vehiculo/existsByChasis")
    public boolean existsByChasis(String chasis){
        return vehiculoServicio.existeChasis(chasis);
    }
}

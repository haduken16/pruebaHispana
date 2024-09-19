package com.hispana.clientevehiculo_servicio.Service;
import com.hispana.clientevehiculo_servicio.Model.ModeloDTO;
import java.util.List;

public interface ModeloServicio {

    List<ModeloDTO> listarModelos();
    ModeloDTO guardarModelo(ModeloDTO modelo);
}

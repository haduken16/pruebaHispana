package com.hispana.clientevehiculo_servicio.Service;
import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;
import java.util.List;

public interface MarcaServicio {
    List<MarcaDTO> listarMarcas();

    MarcaDTO guardarMarca(MarcaDTO marca);

}

package com.hispana.clientevehiculo_servicio.Controller;

import com.hispana.clientevehiculo_servicio.Model.MarcaDTO;
import com.hispana.clientevehiculo_servicio.Service.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MarcaController {
    @Autowired
    private MarcaServicio marcaServicio;

    @GetMapping("/marcas/find")
    public List<MarcaDTO> ListarMarcas(){
        return marcaServicio.listarMarcas();
    }

    @PostMapping("/marcas/save")
    public String guardarMarca(@RequestBody MarcaDTO marca){
        marcaServicio.guardarMarca(marca);
        return "Marca guardada";
    }
}

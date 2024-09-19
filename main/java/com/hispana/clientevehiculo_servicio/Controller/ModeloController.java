package com.hispana.clientevehiculo_servicio.Controller;

import com.hispana.clientevehiculo_servicio.Model.ModeloDTO;
import com.hispana.clientevehiculo_servicio.Service.ModeloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ModeloController {
    @Autowired
    private ModeloServicio modeloServicio;

    @GetMapping("/modelo/find")
    public List<ModeloDTO> ListarModelos(){
        return modeloServicio.listarModelos();
    }

    @PostMapping("/modelo/save")
    public String guardarModelo(@RequestBody ModeloDTO modelo){
        modeloServicio.guardarModelo(modelo);
        return "Modelo guardado";
    }
}

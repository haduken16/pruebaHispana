package com.hispana.clientevehiculo_servicio.Controller;

import com.hispana.clientevehiculo_servicio.Error.ValidacionesExceptions;
import com.hispana.clientevehiculo_servicio.Model.Cliente;
import com.hispana.clientevehiculo_servicio.Model.ClienteDTO;
import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import com.hispana.clientevehiculo_servicio.Service.ClienteServicio;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ClienteController {
    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping("/find")
    public List<ClienteDTO> listarClientes(@RequestParam(required=true,name="identificacion") String ide) {
        return clienteServicio.listarClientes(ide);
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveCliente(@Valid @RequestBody ClienteDTO cliente) throws ValidacionesExceptions {

        ClienteDTO clienteDTO = clienteServicio.guardarCliente(cliente);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

}

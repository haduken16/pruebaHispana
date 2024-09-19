package com.hispana.clientevehiculo_servicio.Repository;

import com.hispana.clientevehiculo_servicio.Model.Cliente;
import com.hispana.clientevehiculo_servicio.Model.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    public List<Cliente> findByIdentificacion (String identificacion);

    public Cliente save(Cliente cliente);

    public boolean existsByIdentificacion (String identificacion);

    public Cliente updateByVehiculos(Cliente cliente);
}

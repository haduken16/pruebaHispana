package com.hispana.clientevehiculo_servicio.Repository;

import com.hispana.clientevehiculo_servicio.Model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
    public List<Modelo> findAllBy();

    public Modelo save(Modelo modelo);
    public Modelo findByDescripcion(String descripcion);
}

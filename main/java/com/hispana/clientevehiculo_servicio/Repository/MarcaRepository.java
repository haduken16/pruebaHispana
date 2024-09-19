package com.hispana.clientevehiculo_servicio.Repository;

import com.hispana.clientevehiculo_servicio.Model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {
    public List<Marca> findAllBy();

    public Marca findByDescripcion(String descripcion);

    public Marca findById(int id);

    public Marca save(Marca marca);
}

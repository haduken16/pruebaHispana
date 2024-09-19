package com.hispana.clientevehiculo_servicio.Repository;

import com.hispana.clientevehiculo_servicio.Model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    public List<Vehiculo> findAllBy();
    public Vehiculo save(Vehiculo vehiculo);
    public Vehiculo findByPlaca(String placa);

    public boolean existsByChasis(String chasis);
    public boolean existsByPlaca(String placa);
}

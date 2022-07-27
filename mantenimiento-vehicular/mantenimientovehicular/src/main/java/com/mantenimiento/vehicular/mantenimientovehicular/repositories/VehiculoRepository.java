package com.mantenimiento.vehicular.mantenimientovehicular.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;


@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    public List<Vehiculo> findByPlaca(String hola);
}

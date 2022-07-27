package com.mantenimiento.vehicular.mantenimientovehicular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mantenimiento.vehicular.mantenimientovehicular.models.Mantenimiento;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
    public List<Mantenimiento> findByVehiculo(Vehiculo vehiculo);

}

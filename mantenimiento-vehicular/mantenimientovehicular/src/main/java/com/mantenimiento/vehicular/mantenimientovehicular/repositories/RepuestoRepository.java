package com.mantenimiento.vehicular.mantenimientovehicular.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mantenimiento.vehicular.mantenimientovehicular.models.Mantenimiento;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Repuesto;

public interface RepuestoRepository  extends JpaRepository<Repuesto, Long>{
    public List<Repuesto> findByMantenimiento(Mantenimiento mantenimiento); 
}

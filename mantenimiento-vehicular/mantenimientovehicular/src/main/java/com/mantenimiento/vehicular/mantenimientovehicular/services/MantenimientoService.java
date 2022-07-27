package com.mantenimiento.vehicular.mantenimientovehicular.services;

import java.util.List;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewMantenimientoDTO;

public interface MantenimientoService {
    
    public MantenimientoDTO create(Long idVehiculo, NewMantenimientoDTO manteniDTO);
    public MantenimientoVehiculoDTO retrieve(Long idVehiculo, Long id);
    public MantenimientoVehiculoDTO update(MantenimientoDTO manteniDTO, Long idVehiculo, Long id);
    public void delete(Long idVehiculo, Long id);

    public List<MantenimientoDTO> list(Long idVehicuLo);
}

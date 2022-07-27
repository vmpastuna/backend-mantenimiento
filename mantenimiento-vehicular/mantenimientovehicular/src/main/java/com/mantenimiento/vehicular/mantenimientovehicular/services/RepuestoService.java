package com.mantenimiento.vehicular.mantenimientovehicular.services;

import java.util.List;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewRepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.RepuestoDTO;

public interface RepuestoService {

    public List<RepuestoDTO> create(Long idVehiculo, Long idManteni, List<NewRepuestoDTO> list);
    public List<RepuestoDTO> list(Long idVehiculo, Long idManteni);
    public void remove(Long idVehiculo, Long idManteni);
}

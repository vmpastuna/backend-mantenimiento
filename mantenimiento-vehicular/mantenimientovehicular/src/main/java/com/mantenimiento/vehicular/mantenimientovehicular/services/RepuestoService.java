package com.mantenimiento.vehicular.mantenimientovehicular.services;

import java.util.List;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewRepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.RepuestoDTO;

public interface RepuestoService {
    public RepuestoDTO create(Long idVehi, NewRepuestoDTO ingredientDTO);
    public void delete(Long idVehi, Long id);
    public List<RepuestoDTO> list(Long idVehi);
}

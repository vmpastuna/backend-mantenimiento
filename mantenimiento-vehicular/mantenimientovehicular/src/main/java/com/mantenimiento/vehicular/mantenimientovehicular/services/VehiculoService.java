package com.mantenimiento.vehicular.mantenimientovehicular.services;

import java.util.List;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoListDTO;

public interface VehiculoService {
    
    public VehiculoDTO create(NewVehiculoDTO vehiculoDTO);
    public VehiculoDTO retrieve(Long id);
    public VehiculoDTO update(VehiculoDTO vehiculoDTO, Long id);
    public void delete(Long id);
    public long count();

    public List<VehiculoListDTO> list(int page, int size, String sort);

}

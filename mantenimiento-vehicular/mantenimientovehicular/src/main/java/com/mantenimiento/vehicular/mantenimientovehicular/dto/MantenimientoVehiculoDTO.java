package com.mantenimiento.vehicular.mantenimientovehicular.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MantenimientoVehiculoDTO extends MantenimientoDTO {
     private VehiculoDTO vehiculo;
}

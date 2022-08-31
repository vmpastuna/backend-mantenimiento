package com.mantenimiento.vehicular.mantenimientovehicular.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RepuestoVehiculoDTO extends RepuestoDTO{
    private VehiculoDTO recipe;
}

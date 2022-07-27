package com.mantenimiento.vehicular.mantenimientovehicular.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MantenimientoDTO extends NewMantenimientoDTO {
    private Long id;
    private List<RepuestoDTO> repuestos;
}

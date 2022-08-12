package com.mantenimiento.vehicular.mantenimientovehicular.dto;


import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewMantenimientoDTO {
    
    
    private String nombre;
    private Date fechaMantenimiento;
    private double precio;
    private String tipo;

}

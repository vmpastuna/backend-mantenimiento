package com.mantenimiento.vehicular.mantenimientovehicular.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VehiculoListDTO {
 
    private Long id;
    private String placa;
    private String modelo;    
    private String color;   
    private String marca;
}
 

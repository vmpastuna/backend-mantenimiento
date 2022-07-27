package com.mantenimiento.vehicular.mantenimientovehicular.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewRepuestoDTO {

    private String nombre;
    private String tipo;
    private String descripcion;
    private short cantidad;

}

package com.mantenimiento.vehicular.mantenimientovehicular.dto;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewMantenimientoDTO {
    
    
    private String nombre;
    private String fechaMantenimiento;
    private double precio;
    private String tipo;

}

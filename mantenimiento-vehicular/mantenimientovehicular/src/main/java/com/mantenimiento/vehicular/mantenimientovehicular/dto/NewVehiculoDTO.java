package com.mantenimiento.vehicular.mantenimientovehicular.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NewVehiculoDTO {

    @NotNull(message = "Placa width can't be null.")
    private String placa;
    private String modelo; 
    private String color;  
    private String marca;

}

package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvasadoDTO {
    private Integer id_envasado;
    private String tipo_envase;
    private Integer cantidad_envases;
    
    private String nombreProducto;

}


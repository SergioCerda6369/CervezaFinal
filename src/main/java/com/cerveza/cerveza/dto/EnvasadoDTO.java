package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnvasadoDTO {
    private Integer idEnvasado;
    private String tipoEnvase;
    private Integer cantidadEnvases;
    private String nombreProductoFinal;

}


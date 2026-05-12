package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class FermentacionDTO {
    private Integer idFermentacion;
    private String codigoTanque;
    private Integer temperaturaActual;
    private Integer idProduccionAsociada;

}

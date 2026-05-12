package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class RecetasDTO {
    
    private Integer idReceta;
    private String nombreReceta;
    private String tipoCerveza;
    private Integer tiempoCoccion;
    private String nombreMaterialPrincipal;

}

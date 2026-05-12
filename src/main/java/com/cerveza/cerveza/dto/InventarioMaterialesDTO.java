package com.cerveza.cerveza.dto;

import lombok.Data;

@Data
public class InventarioMaterialesDTO {

    private Integer idMaterial;
    private String nombreMaterial;
    private Integer cantidadStock;
    private String nombreProveedor;

}

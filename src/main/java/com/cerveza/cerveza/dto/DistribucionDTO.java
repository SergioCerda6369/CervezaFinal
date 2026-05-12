package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistribucionDTO {
    private Integer idDistribucion;
    private String patenteCamion;
    private String nombreConductor;
    private String estadoDistribucion;
    private String clienteDelPedido;

}

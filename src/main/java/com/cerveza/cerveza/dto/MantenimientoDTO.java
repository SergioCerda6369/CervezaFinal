package com.cerveza.cerveza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MantenimientoDTO {
    private Integer idMantenimiento;
    private String tipoEquipo;
    private String codigoEquipo;
    private String estadoEquipo;
    private String estadoMantenimiento;
    private String codigoTanqueMantenimiento;

}

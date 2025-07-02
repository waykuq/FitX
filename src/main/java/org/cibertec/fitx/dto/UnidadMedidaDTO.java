package org.cibertec.fitx.dto;

import lombok.Data;

@Data
public class UnidadMedidaDTO {
    private Integer id;
    private String nombre;
    private String simbolo;
    private Double factorConversion;
}

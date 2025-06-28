package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Set;

@Data
public class RecetaDetalleDTO {
    private Integer id;
    private Integer recetaId;
    private Integer insumoId;
    private String insumoNombre;
    private Integer insumoMedidaId;
    private Integer unidadMedidaId;
    private String unidadMedidaSimbolo;
    private Double cantidad;
}
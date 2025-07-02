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
    private double insumoPrecio;
    private double insumoCalorias;
    private double insumoProteinas;
    private double insumoGrasas;
    private double insumoCarbohidratos;

    private Integer unidadMedidaId;
    private String unidadMedidaSimbolo;
    private Double cantidad;
    private boolean editable = false;
}
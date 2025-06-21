package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class RecetaMinDTO {
    private Integer id;
    private String nombre;
//    private Integer porciones;
//    private double pesoPorcion;
//    private String unidadMedidaSimbolo;
//    private LocalTime tiempoEstimado;
//    private String estado;
//    private String foto;
    // Solo los campos esenciales, NO colecciones ni referencias a EtiquetaMinDTO
}
package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuMinDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaEjecucion;
    private Integer cantidadRecetas;
}
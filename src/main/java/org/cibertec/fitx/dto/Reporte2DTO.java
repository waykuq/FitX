package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Reporte2DTO {
    private Integer usuarioId;
    private String dni;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precio;
    private String estado;
}
package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SuscripcionDTO {
    private Integer id;
    private String usuarioNombre;
    private String usuarioDni;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precio;
    private String estado;
}

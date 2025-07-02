package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SuscripcionMinDTO {
    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precio;
}

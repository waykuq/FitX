package org.cibertec.fitx.dto;

import lombok.Data;

@Data
public class EtiquetaMinDTO {
    private Integer id;
    private String nombre;
    private String color;
    // Solo los campos esenciales, NO colecciones ni referencias a RecetaMinDTO
}
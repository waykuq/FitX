package org.cibertec.fitx.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EtiquetaDTO {
    private Integer id;
    private String nombre;
    private String color;
    private String estado;
    private Integer usuarioId;
//    private String nombreUsuario;

    // Si necesitas que el DTO de Etiqueta incluya información de las Recetas
    // Es crucial que RecetaDTO NO incluya EtiquetaDTO para evitar el ciclo.
//    private Set<RecetaMinDTO> recetas; // Usa un DTO simplificado para evitar el ciclo
}
package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set; // Necesario si quieres incluir etiquetas en este DTO

@Data
public class RecetaDTO {
    private Integer id;
    private String nombre;
    private Integer porciones;
    private double pesoPorcion;
    private String unidadMedidaSimbolo;
    private LocalTime tiempoEstimado;
    private String estado;
    private String foto;
    private Integer usuarioId; // Solo el ID del usuario
    //private String nombreUsuario; // Opcional: el nombre del usuario

    // Aquí es donde defines la "referencia bidireccional"
    // Usamos un DTO simplificado para Etiqueta para evitar el ciclo.
    private Set<EtiquetaMinDTO> etiquetas; // Usamos un DTO mínimo para Etiqueta
}
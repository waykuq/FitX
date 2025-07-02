package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.Set;

@Data
public class RecetaDTO {
    private Integer id;
    private String nombre;
    private Integer porciones;
    private double pesoPorcion;
    private int unidadMedidaId;
    private String unidadMedidaSimbolo;
    private LocalTime tiempoEstimado;
    private String foto;
    private Integer usuarioId;
    private String nombreUsuario;
    private boolean editable = false;
    private String descripcion;

    private Set<EtiquetaMinDTO> etiquetas;
    private Set<RecetaDetalleDTO> detalles;

    private ValorNutricionalRecetaDTO valorNutricional;
}
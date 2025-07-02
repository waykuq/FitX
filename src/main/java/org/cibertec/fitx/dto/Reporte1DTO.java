package org.cibertec.fitx.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Reporte1DTO {
    private Integer usuarioId;
    private String dni;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
    private String rol;
    private Integer rolId;

    private LocalDate fechaInicioUltimaSuscripcion;
    private LocalDate fechaFinUltimaSuscripcion;

    private String estadoSuscripcion;
    private List<SuscripcionMinDTO> suscripciones;

    private List<MenuMinDTO> menus;

    private List<RecetaMinDTO> recetas;
}
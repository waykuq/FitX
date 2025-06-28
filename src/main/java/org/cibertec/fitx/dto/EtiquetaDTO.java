package org.cibertec.fitx.dto;

import lombok.Data;

import java.util.Set;

@Data
public class EtiquetaDTO {
    private Integer id;
    private String nombre;
    private String color;
//    private String estado;
    private Integer usuarioId;
    private boolean editable = false;
//    private String nombreUsuario;

//    private Set<RecetaMinDTO> recetas;
}
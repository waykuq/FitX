package org.cibertec.fitx.dto;

import lombok.Data;

@Data
public class InsumoDTO {
    private Integer id;
    private String nombre;
    private Integer tipoId;
    private String tipoNombre;
    private Integer unidadId;
    private String unidadNombre;
}

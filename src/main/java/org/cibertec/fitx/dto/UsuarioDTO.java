package org.cibertec.fitx.dto;

import groovy.lang.GString;
import jakarta.persistence.*;
import lombok.Data;
import org.cibertec.fitx.entity.TipoUsuarioEntity;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
public class UsuarioDTO {

    private Integer id;
    private Integer rolId;
    private String rolNombre;
    private String dni;
    private String nombreUsuario;
    private String nombres;
    private String apellidos;
    private String correo;
    private String telefono;
}

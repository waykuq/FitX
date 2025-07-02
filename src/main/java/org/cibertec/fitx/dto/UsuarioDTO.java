package org.cibertec.fitx.dto;

import lombok.Data;

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

    // Solo se usa en el registro
    private String contraseña;

    private double peso;
    private double altura;
    private LocalDate fechaNacimiento;
    private String sexo;
    private String nivel_actividad;

}

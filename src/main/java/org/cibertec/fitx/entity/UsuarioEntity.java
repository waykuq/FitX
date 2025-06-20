package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuarioEntity tipoUsuario;

    @Column(name = "nombre_usuario")//, length = 50)
    private String nombreUsuario;

    @Column(name = "dni")//, length = 8)
    private String dni;

    @Column(name = "nombres")//, length = 100)
    private String nombres;

    @Column(name = "apellidos")//, length = 100)
    private String apellidos;

    @Column(name = "correo")//, length = 100)
    private String correo;

    @Column(name = "`contraseña`")//, length = 100)
    private String contraseña;

    @Column(name = "fecha_inscripcion")
    private LocalDate fechaInscripcion;

    @ColumnDefault("'Activo'")
    // @Lob
    @Column(name = "estado")
    private String estado;

    @Column(name = "telefono")//, length = 15)
    private String telefono;

}
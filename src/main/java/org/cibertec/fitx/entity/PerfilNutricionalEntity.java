package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "PerfilNutricional")
public class PerfilNutricionalEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private UsuarioEntity usuario;

    @Column(name = "peso")
    private double peso;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    // @Lob
    @Column(name = "sexo")
    private char sexo;

    @Column(name = "talla")//, precision = 5, scale = 2)
    private double talla;

    // @Lob
    @Column(name = "nivel_actividad")
    private String nivelActividad;

}
package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Receta")
public class RecetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "porciones")
    private Integer porciones;

    @Column(name = "peso_porcion")//, precision = 5, scale = 2)
    private double pesoPorcion;

    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedidaEntity unidadMedida;

    @Column(name = "tiempo_estimado")
    private LocalTime tiempoEstimado;

    @ColumnDefault("'Activo'")
    // @Lob
    @Column(name = "estado")
    private String estado;

    // @Lob
    @Column(name = "foto")
    private String foto;

    // @Lob
    @Column(name = "descripcion")
    private String descripcion;

}
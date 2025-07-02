package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@ToString(exclude = {"usuario", "unidadMedida", "etiquetas", "detalles", "menuRecetas", "favoritas"})
@EqualsAndHashCode(exclude = {"usuario", "unidadMedida", "etiquetas", "detalles", "menuRecetas", "favoritas"})
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

    @ManyToMany
    @JoinTable(
            name = "RecetaEtiqueta",
            joinColumns = @JoinColumn(name = "id_receta"),
            inverseJoinColumns = @JoinColumn(name = "id_etiqueta")
    )
    private Set<EtiquetaEntity> etiquetas = new HashSet<>();

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<RecetaDetalleEntity> detalles = new HashSet<>();

    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuRecetaEntity> menuRecetas = new HashSet<>();

//    @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<RecetaFavoritaEntity> favoritas = new HashSet<>();


}
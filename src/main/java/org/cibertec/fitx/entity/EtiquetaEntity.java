package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Set;

//@Data
@Getter
@Setter
@ToString(exclude = "recetas")
@EqualsAndHashCode(exclude = {"usuario", "recetas"})
@Entity
@Table(name = "Etiqueta")
public class EtiquetaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "color")
    private String color;

    @ColumnDefault("'Activo'")
    // @Lob
    @Column(name = "estado")
    private String estado;

    @ManyToMany(mappedBy = "etiquetas")
    private Set<RecetaEntity> recetas = new HashSet<>();

}
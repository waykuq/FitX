package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
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

}
package org.cibertec.fitx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@ToString(exclude = {"receta", "usuario"})
@EqualsAndHashCode(exclude = {"receta", "usuario"})
@Entity
@Table(name = "RecetaFavorita")
public class RecetaFavoritaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    // @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_receta")
    @JsonIgnore // si usas Jackson
    private RecetaEntity receta;


    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

    @Column(name = "fecha_agregado")
    private Instant fechaAgregado;

}
package org.cibertec.fitx.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"menu", "receta"})
@EqualsAndHashCode(exclude = {"menu", "receta"})
@Entity
@Table(name = "MenuReceta")
public class MenuRecetaEntity {
    @EmbeddedId
    private MenuRecetaEntityId id;

    @MapsId("idMenu")
    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_menu")
    private MenuEntity menu;

    @MapsId("idReceta")
    @ManyToOne(fetch = FetchType.LAZY)
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_receta")
    @JsonIgnore
    private RecetaEntity receta;

    @Column(name = "porciones")
    private Integer porciones;

}
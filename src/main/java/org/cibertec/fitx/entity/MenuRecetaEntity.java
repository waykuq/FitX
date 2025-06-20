package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
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
    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_receta")
    private RecetaEntity receta;

    @Column(name = "porciones")
    private Integer porciones;

}
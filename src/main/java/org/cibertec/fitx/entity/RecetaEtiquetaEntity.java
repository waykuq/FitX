package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RecetaEtiqueta")
public class RecetaEtiquetaEntity {
    @EmbeddedId
    private RecetaEtiquetaEntityId id;

    @MapsId("idEtiqueta")
    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_etiqueta")
    private EtiquetaEntity etiqueta;

    @MapsId("idReceta")
    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_receta")
    private RecetaEntity receta;

}
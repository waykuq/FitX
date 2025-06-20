package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "RecetaDetalle")
public class RecetaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_receta")
    private RecetaEntity receta;

    @ManyToOne
    @JoinColumn(name = "id_insumo")
    private InsumoEntity insumo;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedidaEntity unidadMedida;

    @Column(name = "cantidad")//, precision = 8, scale = 2)
    private double cantidad;

    @ColumnDefault("'Activo'")
    // @Lob
    @Column(name = "estado")
    private String estado;

}
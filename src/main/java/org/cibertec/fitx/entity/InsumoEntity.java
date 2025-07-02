package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "Insumo")
public class InsumoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedidaEntity unidadMedida;

    @ManyToOne
    @JoinColumn(name = "id_tipo_insumo")
    private TipoInsumoEntity tipoInsumo;

//    @OneToOne(mappedBy = "insumo", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "insumo", cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private ValorNutricionalEntity valorNutricional;

    @Column(name = "nombre")
    private String nombre;

    @ColumnDefault("'Activo'")
    // @Lob
    @Column(name = "estado")
    private String estado;

}
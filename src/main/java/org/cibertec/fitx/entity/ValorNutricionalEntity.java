package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ValorNutricional")
public class ValorNutricionalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    // @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_insumo")
    private InsumoEntity insumo;

    @ManyToOne
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedidaEntity unidadMedida;

    @Column(name = "cantidad")//, precision = 10, scale = 2)
    private double cantidad;

    @Column(name = "calorias")//, precision = 10, scale = 2)
    private double calorias;

    @Column(name = "proteinas")//, precision = 10, scale = 2)
    private double proteinas;

    @Column(name = "grasas")//, precision = 10, scale = 2)
    private double grasas;

    @Column(name = "carbohidratos")//, precision = 10, scale = 2)
    private double carbohidratos;

}
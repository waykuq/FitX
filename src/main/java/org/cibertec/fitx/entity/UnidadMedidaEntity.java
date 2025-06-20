package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "UnidadMedida")
public class UnidadMedidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")//, length = 50)
    private String nombre;

    @Column(name = "simbolo")//, length = 10)
    private String simbolo;

}
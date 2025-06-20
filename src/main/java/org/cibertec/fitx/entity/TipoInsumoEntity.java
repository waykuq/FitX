package org.cibertec.fitx.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TipoInsumo")
public class TipoInsumoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")//, length = 50)
    private String nombre;

}
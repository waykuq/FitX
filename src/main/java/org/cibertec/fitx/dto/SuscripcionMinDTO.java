package org.cibertec.fitx.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Data
public class SuscripcionMinDTO {
    private Integer id;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precio;
}

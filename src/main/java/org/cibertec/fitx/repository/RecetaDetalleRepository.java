package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetaDetalleRepository extends JpaRepository<RecetaDetalleEntity, Integer> {

    List<RecetaDetalleEntity> findByRecetaId(Integer recetaId);

}
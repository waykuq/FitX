package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.entity.SuscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscripcionRepository extends JpaRepository<SuscripcionEntity, Integer> {

    List<SuscripcionEntity> findByUsuarioId(Integer usuarioId);

}
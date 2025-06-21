package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.EtiquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtiquetaRepository extends JpaRepository<EtiquetaEntity, Integer> {

    List<EtiquetaEntity> findByUsuarioIdOrEsDelSistemaTrue(Integer usuarioId);

}
package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.EtiquetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtiquetaRepository extends JpaRepository<EtiquetaEntity, Integer> {
//
//    List<EtiquetaEntity> findByUsuarioIdOrEsDelSistemaTrue(Integer usuarioId);

    @Query("""
    SELECT e FROM EtiquetaEntity e 
    LEFT JOIN e.usuario u
    LEFT JOIN u.tipoUsuario t
    WHERE u.id = :usuarioId 
       OR t.nombre = 'Administrador'
""")
    List<EtiquetaEntity> findVisiblesPorUsuario(@Param("usuarioId") Integer usuarioId);


}
package org.cibertec.fitx.repository;

import org.cibertec.fitx.dto.ValorNutricionalRecetaDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.entity.ValorNutricionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecetaRepository extends JpaRepository<RecetaEntity, Integer> {

    @Query("""
        SELECT DISTINCT r FROM RecetaEntity r 
        LEFT JOIN FETCH r.usuario 
        LEFT JOIN FETCH r.etiquetas
    """)
    List<RecetaEntity> findAllWithDetails();

    @Query("""
        SELECT DISTINCT r FROM RecetaEntity r 
        LEFT JOIN FETCH r.usuario u
        LEFT JOIN FETCH r.etiquetas e
        LEFT JOIN u.tipoUsuario t
        WHERE u.id = :usuarioId 
           OR t.nombre = 'Administrador'
    """)
    List<RecetaEntity> findVisiblesPorUsuario(@Param("usuarioId") Integer usuarioId);

//    @Procedure("sp_obtener_valor_nutricional_receta")
    @Query(value = "CALL sp_obtener_valor_nutricional_receta(:id)", nativeQuery = true)
    ValorNutricionalRecetaDTO valorNutricionalRecetaDto(@Param("id") Integer id);

    List<RecetaEntity> findByUsuarioId(Integer usuarioId);
}
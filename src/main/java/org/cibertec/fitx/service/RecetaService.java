package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.entity.RecetaEntity;

import java.util.List;

public interface RecetaService extends GenericService<RecetaEntity, Integer> {

    // Método modificado para devolver DTOs
    public List<RecetaDTO> listarRecetaDTO();

    // Nuevo método para buscar una sola etiqueta y devolverla como DTO
    public RecetaDTO buscarRecetaDtoPorId(Integer id);

    // Nuevo método para mapear una RecetaEntity a RecetaDTO (útil internamente)
    public RecetaDTO mapearEntidadADto(RecetaEntity etiquetaEntity);
    
}
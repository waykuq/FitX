package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.entity.InsumoEntity;

import java.util.List;

public interface InsumoService extends GenericService<InsumoEntity, Integer> {
    // Método modificado para devolver DTOs
    public List<InsumoDTO> listarInsumoDTO();

    // Nuevo método para buscar una sola etiqueta y devolverla como DTO
    public InsumoDTO buscarInsumoDtoPorId(Integer id);

    // Nuevo método para mapear una InsumoEntity a InsumoDTO (útil internamente)
    public InsumoDTO mapearEntidadADto(InsumoEntity etiquetaEntity);
}
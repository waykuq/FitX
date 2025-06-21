package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.UnidadMedidaDTO;
import org.cibertec.fitx.entity.UnidadMedidaEntity;
import org.cibertec.fitx.entity.UnidadMedidaEntity;

import java.util.List;

public interface UnidadMedidaService extends GenericService<UnidadMedidaEntity, Integer> {
    public List<UnidadMedidaDTO> listarUnidadMedidaDTO();

    // Nuevo método para buscar una sola etiqueta y devolverla como DTO
    public UnidadMedidaDTO buscarUnidadMedidaDtoPorId(Integer id);

    // Nuevo método para mapear una UnidadMedidaEntity a UnidadMedidaDTO (útil internamente)
    public UnidadMedidaDTO mapearEntidadADto(UnidadMedidaEntity etiquetaEntity);
}
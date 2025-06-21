package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.TipoInsumoDTO;
import org.cibertec.fitx.entity.TipoInsumoEntity;
import org.cibertec.fitx.entity.TipoInsumoEntity;

import java.util.List;

public interface TipoInsumoService extends GenericService<TipoInsumoEntity, Integer> {
    public List<TipoInsumoDTO> listarTipoInsumoDTO();

    // Nuevo método para buscar una sola etiqueta y devolverla como DTO
    public TipoInsumoDTO buscarTipoInsumoDtoPorId(Integer id);

    // Nuevo método para mapear una TipoInsumoEntity a TipoInsumoDTO (útil internamente)
    public TipoInsumoDTO mapearEntidadADto(TipoInsumoEntity etiquetaEntity);
}
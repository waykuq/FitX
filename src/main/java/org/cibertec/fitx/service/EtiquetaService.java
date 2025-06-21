package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;

import java.util.List;


public interface EtiquetaService extends GenericService<EtiquetaEntity, Integer> {

    // Método modificado para devolver DTOs
    public List<EtiquetaDTO> listarPorUsuario(Integer usuarioId);

    // Nuevo método para buscar una sola etiqueta y devolverla como DTO
    public EtiquetaDTO buscarEtiquetaDtoPorId(Integer id);

    // Nuevo método para mapear una EtiquetaEntity a EtiquetaDTO (útil internamente)
    public EtiquetaDTO mapearEntidadADto(EtiquetaEntity etiquetaEntity);

}
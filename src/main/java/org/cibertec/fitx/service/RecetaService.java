package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.entity.RecetaEntity;

import java.util.List;

public interface RecetaService extends GenericService<RecetaEntity, Integer> {

    public List<RecetaDTO> listarRecetaDTO();

    public RecetaDTO buscarRecetaDtoPorId(Integer id);

    public RecetaDTO mapearEntidadADto(RecetaEntity recetaEntity);

//    public RecetaEntity mapearDtoAEntidad(RecetaDTO recetaDTO);

    public List<RecetaDTO> listarPorUsuarioDTO(Integer usuarioId);

    public void guardarReceta(RecetaDTO recetaActualizadaDTO);

}
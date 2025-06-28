package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.dto.RecetaDetalleDTO;
import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.cibertec.fitx.entity.RecetaEntity;

import java.util.List;


public interface RecetaDetalleService extends GenericService<RecetaDetalleEntity, Integer> {

    public List<RecetaDetalleDTO> listarPorRecetaDto(Integer recetaId);

    public RecetaDetalleDTO mapearEntidadADto(RecetaDetalleEntity recetaDetalleEntity);
}
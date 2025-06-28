package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;

import java.util.List;


public interface EtiquetaService extends GenericService<EtiquetaEntity, Integer> {

    public List<EtiquetaDTO> listarTodas();

    public List<EtiquetaDTO> listarPorUsuario(Integer usuarioId);

    public EtiquetaDTO buscarEtiquetaDtoPorId(Integer id);

    public EtiquetaDTO mapearEntidadADto(EtiquetaEntity etiquetaEntity);

}
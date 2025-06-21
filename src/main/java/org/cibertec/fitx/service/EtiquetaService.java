package org.cibertec.fitx.service;

import org.cibertec.fitx.entity.EtiquetaEntity;

import java.util.List;


public interface EtiquetaService extends GenericService<EtiquetaEntity, Integer> {

    public List<EtiquetaEntity> listarPorUsuario(Integer usuarioId);

}
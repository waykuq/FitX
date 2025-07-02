package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.MenuMinDTO;
import org.cibertec.fitx.dto.SuscripcionMinDTO;
import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.entity.SuscripcionEntity;

import java.util.List;

public interface SuscripcionService extends GenericService<SuscripcionEntity, Integer> {

    public SuscripcionMinDTO mapearEntidadAMinDto(SuscripcionEntity suscripcion);

    public List<SuscripcionMinDTO> listarSuscripcionPorUsuarioMinDto(Integer usuarioId);

}
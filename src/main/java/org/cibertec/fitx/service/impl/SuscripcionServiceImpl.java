package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.MenuMinDTO;
import org.cibertec.fitx.dto.SuscripcionMinDTO;
import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.entity.SuscripcionEntity;
import org.cibertec.fitx.repository.MenuRepository;
import org.cibertec.fitx.repository.SuscripcionRepository;
import org.cibertec.fitx.service.SuscripcionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuscripcionServiceImpl extends GenericServiceImpl<SuscripcionEntity, Integer> implements SuscripcionService {

	public SuscripcionServiceImpl(JpaRepository<SuscripcionEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public SuscripcionMinDTO mapearEntidadAMinDto(SuscripcionEntity suscripcion) {
		if (suscripcion == null) return null;
		SuscripcionMinDTO dto = new SuscripcionMinDTO();
		dto.setId(suscripcion.getId());
		dto.setFechaInicio(suscripcion.getFechaInicio());
		dto.setFechaFin(suscripcion.getFechaFin());
		dto.setPrecio(suscripcion.getPrecio());
		return dto;
	}

	@Override
	public List<SuscripcionMinDTO> listarSuscripcionPorUsuarioMinDto(Integer usuarioId) {
		List<SuscripcionEntity> suscripciones = ((SuscripcionRepository) repository).findByUsuarioId(usuarioId);
		return suscripciones.stream()
				.map(this::mapearEntidadAMinDto)
				.collect(Collectors.toList());
	}

}

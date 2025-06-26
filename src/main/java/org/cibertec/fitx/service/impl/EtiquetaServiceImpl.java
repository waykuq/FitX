package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.EtiquetaDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.repository.EtiquetaRepository;
import org.cibertec.fitx.service.EtiquetaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EtiquetaServiceImpl extends GenericServiceImpl<EtiquetaEntity, Integer> implements EtiquetaService {

	public EtiquetaServiceImpl(JpaRepository<EtiquetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public List<EtiquetaDTO> listarPorUsuario(Integer usuarioId) {
		List<EtiquetaEntity> etiquetas = ((EtiquetaRepository) repository).findVisiblesPorUsuario(usuarioId);
		return etiquetas.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	public EtiquetaDTO buscarEtiquetaDtoPorId(Integer id) {
		Optional<EtiquetaEntity> etiquetaOptional = ((EtiquetaRepository) repository).findById(id); // Usa findById del JpaRepository
		return etiquetaOptional.map(this::mapearEntidadADto).orElse(null); // Mapea si existe, sino null
	}

	// Método de mapeo de entidad a DTO (implementación reusable)
	@Override
	public EtiquetaDTO mapearEntidadADto(EtiquetaEntity etiquetaEntity) {
		if (etiquetaEntity == null) {
			return null;
		}

		EtiquetaDTO dto = new EtiquetaDTO();
		dto.setId(etiquetaEntity.getId());
		dto.setNombre(etiquetaEntity.getNombre());
		dto.setColor(etiquetaEntity.getColor());
		dto.setEstado(etiquetaEntity.getEstado());

		if (etiquetaEntity.getUsuario() != null) {
			dto.setUsuarioId(etiquetaEntity.getUsuario().getId());
//			dto.setNombreUsuario(etiquetaEntity.getUsuario().getNombreUsuario());
		}

		return dto;
	}

}

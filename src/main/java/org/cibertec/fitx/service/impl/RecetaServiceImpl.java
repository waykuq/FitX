package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.dto.EtiquetaMinDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.repository.RecetaRepository;
import org.cibertec.fitx.service.RecetaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecetaServiceImpl extends GenericServiceImpl<RecetaEntity, Integer> implements RecetaService {

	public RecetaServiceImpl(JpaRepository<RecetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	@Transactional
	public List<RecetaDTO> listarRecetaDTO() {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findAll();
		return recetas.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public RecetaDTO buscarRecetaDtoPorId(Integer id) {
		Optional<RecetaEntity> recetaOptional = ((RecetaRepository) repository).findById(id);
		return recetaOptional.map(this::mapearEntidadADto).orElse(null);
	}

	// Método de mapeo de entidad a DTO (implementación reusable)
	@Override
	public RecetaDTO mapearEntidadADto(RecetaEntity recetaEntity) {
		if (recetaEntity == null) {
			return null;
		}

		RecetaDTO dto = new RecetaDTO();
		dto.setId(recetaEntity.getId());
		dto.setNombre(recetaEntity.getNombre());
		dto.setPorciones(recetaEntity.getPorciones());
		dto.setPesoPorcion(recetaEntity.getPesoPorcion());
		dto.setUnidadMedidaSimbolo(
				(recetaEntity.getUnidadMedida() != null) ? recetaEntity.getUnidadMedida().getSimbolo() : null
		);
		dto.setTiempoEstimado(recetaEntity.getTiempoEstimado());
		dto.setFoto(recetaEntity.getFoto());
		//dto.setUsuarioId(recetaEntity.getUsuario().getId());
		if (recetaEntity.getUsuario() != null) {
			dto.setUsuarioId(recetaEntity.getUsuario().getId());
			dto.setNombreUsuario(recetaEntity.getUsuario().getNombreUsuario());
		} else {
			dto.setUsuarioId(null);
			dto.setNombreUsuario("Usuario Desconocido");
		}

		Set<EtiquetaMinDTO> etiquetasDTO = new HashSet<EtiquetaMinDTO>();

		if (recetaEntity.getEtiquetas() != null) {
			etiquetasDTO = recetaEntity.getEtiquetas().stream()
					.map(e -> {
						EtiquetaMinDTO etiquetaDto = new EtiquetaMinDTO();
						etiquetaDto.setId(e.getId());
						etiquetaDto.setNombre(e.getNombre());
						etiquetaDto.setColor(e.getColor());
						return etiquetaDto;
					})
					.collect(Collectors.toSet());
		}
		dto.setEtiquetas(etiquetasDTO);

		return dto;
	}
}

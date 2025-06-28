package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.RecetaDTO;
import org.cibertec.fitx.dto.EtiquetaMinDTO;
import org.cibertec.fitx.dto.RecetaDetalleDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.repository.RecetaDetalleRepository;
import org.cibertec.fitx.repository.RecetaRepository;
import org.cibertec.fitx.service.RecetaDetalleService;
import org.cibertec.fitx.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	RecetaDetalleRepository detalleRepository;

	@Override
	public List<RecetaDTO> listarRecetaDTO() {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findAllWithDetails();
		return recetas.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	public List<RecetaDTO> listarPorUsuarioDTO(Integer usuarioId) {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findVisiblesPorUsuario(usuarioId);
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
		dto.setUnidadMedidaId(
				(recetaEntity.getUnidadMedida() != null) ? recetaEntity.getUnidadMedida().getId() : null
		);
		dto.setUnidadMedidaSimbolo(
				(recetaEntity.getUnidadMedida() != null) ? recetaEntity.getUnidadMedida().getSimbolo() : null
		);
		dto.setTiempoEstimado(recetaEntity.getTiempoEstimado());
		dto.setFoto(recetaEntity.getFoto());
		dto.setDescripcion(recetaEntity.getDescripcion());

		if (recetaEntity.getUsuario() != null) {
			dto.setUsuarioId(recetaEntity.getUsuario().getId());
			dto.setNombreUsuario(recetaEntity.getUsuario().getNombreUsuario());
		} else {
			dto.setUsuarioId(null);
			dto.setNombreUsuario("Usuario Desconocido");
		}

		// Lista de etiquetas
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


		// Lista de detalle
		List<RecetaDetalleEntity> detalles = detalleRepository.findByRecetaId(recetaEntity.getId());

		Set<RecetaDetalleDTO> detallesDTO = new HashSet<RecetaDetalleDTO>();
		if (detalles != null) {
			detallesDTO = detalles.stream()
					.map(e -> {
						RecetaDetalleDTO detalleDto = new RecetaDetalleDTO();
						detalleDto.setId(e.getId());
						detalleDto.setRecetaId(e.getReceta().getId());
						detalleDto.setInsumoId(e.getInsumo().getId());
						detalleDto.setInsumoNombre(e.getInsumo().getNombre());
						detalleDto.setInsumoMedidaId(e.getInsumo().getUnidadMedida().getId());
						detalleDto.setUnidadMedidaId(e.getUnidadMedida().getId());
						detalleDto.setUnidadMedidaSimbolo(e.getUnidadMedida().getSimbolo());
						detalleDto.setCantidad(e.getCantidad());
						return detalleDto;
					})
					.collect(Collectors.toSet());
		}
		dto.setDetalles(detallesDTO);

		return dto;
	}
}

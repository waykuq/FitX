package org.cibertec.fitx.service.impl;


import org.cibertec.fitx.dto.RecetaDetalleDTO;
import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.cibertec.fitx.repository.RecetaDetalleRepository;
import org.cibertec.fitx.service.RecetaDetalleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecetaDetalleServiceImpl extends GenericServiceImpl<RecetaDetalleEntity, Integer> implements RecetaDetalleService {

	public RecetaDetalleServiceImpl(JpaRepository<RecetaDetalleEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	public List<RecetaDetalleDTO> listarPorRecetaDto(Integer recetaId) {
		List<RecetaDetalleEntity> recetaDetalles = ((RecetaDetalleRepository) repository).findByRecetaId(recetaId);
		return recetaDetalles.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	public RecetaDetalleDTO mapearEntidadADto(RecetaDetalleEntity recetaDetalleEntity){
		if (recetaDetalleEntity == null) {
			return null;
		}

		RecetaDetalleDTO dto = new RecetaDetalleDTO();
		dto.setId(recetaDetalleEntity.getId());
		dto.setRecetaId(recetaDetalleEntity.getReceta().getId());
		dto.setInsumoId(recetaDetalleEntity.getInsumo().getId());
		dto.setInsumoNombre(recetaDetalleEntity.getInsumo().getNombre());
		dto.setInsumoMedidaId(recetaDetalleEntity.getInsumo().getUnidadMedida().getId());
		dto.setCantidad(recetaDetalleEntity.getCantidad());

		return dto;
	}

}

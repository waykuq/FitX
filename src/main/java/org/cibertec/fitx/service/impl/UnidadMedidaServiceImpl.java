package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.UnidadMedidaDTO;
import org.cibertec.fitx.entity.UnidadMedidaEntity;
import org.cibertec.fitx.entity.UnidadMedidaEntity;
import org.cibertec.fitx.repository.UnidadMedidaRepository;
import org.cibertec.fitx.service.UnidadMedidaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnidadMedidaServiceImpl extends GenericServiceImpl<UnidadMedidaEntity, Integer> implements UnidadMedidaService {

	public UnidadMedidaServiceImpl(JpaRepository<UnidadMedidaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public List<UnidadMedidaDTO> listarUnidadMedidaDTO() {
		List<UnidadMedidaEntity> unidadesMedida = ((UnidadMedidaRepository) repository).findAll();
		return unidadesMedida.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	public UnidadMedidaDTO buscarUnidadMedidaDtoPorId(Integer id) {
		Optional<UnidadMedidaEntity> unidadMedidaOptional = ((UnidadMedidaRepository) repository).findById(id);
		return unidadMedidaOptional.map(this::mapearEntidadADto).orElse(null);
	}

	// Método de mapeo de entidad a DTO (implementación reusable)
	@Override
	public UnidadMedidaDTO mapearEntidadADto(UnidadMedidaEntity unidadMedidaEntity) {
		if (unidadMedidaEntity == null) {
			return null;
		}

		UnidadMedidaDTO dto = new UnidadMedidaDTO();
		dto.setId(unidadMedidaEntity.getId());
		dto.setNombre(unidadMedidaEntity.getNombre());
		dto.setSimbolo(unidadMedidaEntity.getSimbolo());

		return dto;
	}
}

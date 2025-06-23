package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.repository.InsumoRepository;
import org.cibertec.fitx.service.InsumoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsumoServiceImpl extends GenericServiceImpl<InsumoEntity, Integer> implements InsumoService {

	public InsumoServiceImpl(JpaRepository<InsumoEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public List<InsumoDTO> listarInsumoDTO() {
		List<InsumoEntity> insumos = ((InsumoRepository) repository).findAll();
		return insumos.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	public InsumoDTO buscarInsumoDtoPorId(Integer id) {
		Optional<InsumoEntity> insumoOptional = ((InsumoRepository) repository).findById(id);
		return insumoOptional.map(this::mapearEntidadADto).orElse(null);
	}

	// Método de mapeo de entidad a DTO (implementación reusable)
	@Override
	public InsumoDTO mapearEntidadADto(InsumoEntity insumoEntity) {
		if (insumoEntity == null) {
			return null;
		}

		InsumoDTO dto = new InsumoDTO();
		dto.setId(insumoEntity.getId());
		dto.setNombre(insumoEntity.getNombre());
		dto.setTipoId(insumoEntity.getTipoInsumo().getId());
		dto.setTipoNombre(insumoEntity.getTipoInsumo().getNombre());
		dto.setUnidadId(insumoEntity.getUnidadMedida().getId());
		dto.setUnidadNombre(insumoEntity.getUnidadMedida().getNombre());

		return dto;
	}
}

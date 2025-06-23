package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.TipoInsumoDTO;
import org.cibertec.fitx.entity.TipoInsumoEntity;
import org.cibertec.fitx.entity.TipoInsumoEntity;
import org.cibertec.fitx.repository.TipoInsumoRepository;
import org.cibertec.fitx.service.TipoInsumoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoInsumoServiceImpl extends GenericServiceImpl<TipoInsumoEntity, Integer> implements TipoInsumoService {

	public TipoInsumoServiceImpl(JpaRepository<TipoInsumoEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public List<TipoInsumoDTO> listarTipoInsumoDTO() {
		List<TipoInsumoEntity> tipoInsumos = ((TipoInsumoRepository) repository).findAll();
		return tipoInsumos.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	public TipoInsumoDTO buscarTipoInsumoDtoPorId(Integer id) {
		Optional<TipoInsumoEntity> tipoInsumoOptional = ((TipoInsumoRepository) repository).findById(id);
		return tipoInsumoOptional.map(this::mapearEntidadADto).orElse(null);
	}

	// Método de mapeo de entidad a DTO (implementación reusable)
	@Override
	public TipoInsumoDTO mapearEntidadADto(TipoInsumoEntity tipoInsumoEntity) {
		if (tipoInsumoEntity == null) {
			return null;
		}

		TipoInsumoDTO dto = new TipoInsumoDTO();
		dto.setId(tipoInsumoEntity.getId());
		dto.setNombre(tipoInsumoEntity.getNombre());

		return dto;
	}
}

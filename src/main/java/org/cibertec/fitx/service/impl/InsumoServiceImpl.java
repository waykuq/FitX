package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.entity.ValorNutricionalEntity;
import org.cibertec.fitx.repository.InsumoRepository;
import org.cibertec.fitx.service.InsumoService;
import org.cibertec.fitx.service.TipoInsumoService;
import org.cibertec.fitx.service.UnidadMedidaService;
import org.cibertec.fitx.service.ValorNutricionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsumoServiceImpl extends GenericServiceImpl<InsumoEntity, Integer> implements InsumoService {

	private final ValorNutricionalService valorNutricionalService;
	private final UnidadMedidaService unidadMedidaService;
	private final TipoInsumoService tipoInsumoService;

	@Autowired
	public InsumoServiceImpl(JpaRepository<InsumoEntity, Integer> repositorio, ValorNutricionalService valorNutricionalService, UnidadMedidaService unidadMedidaService, TipoInsumoService tipoInsumoService) {
		this.repository = repositorio;
		this.valorNutricionalService = valorNutricionalService;
		this.unidadMedidaService = unidadMedidaService;
		this.tipoInsumoService = tipoInsumoService;
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

		dto.setCalorias(insumoEntity.getValorNutricional().getCalorias() * insumoEntity.getValorNutricional().getUnidadMedida().getFactorConversion());
		dto.setCarbohidratos(insumoEntity.getValorNutricional().getCarbohidratos() * insumoEntity.getValorNutricional().getUnidadMedida().getFactorConversion());
		dto.setGrasas(insumoEntity.getValorNutricional().getGrasas() * insumoEntity.getValorNutricional().getUnidadMedida().getFactorConversion());
		dto.setProteinas(insumoEntity.getValorNutricional().getProteinas() * insumoEntity.getValorNutricional().getUnidadMedida().getFactorConversion());

		return dto;
	}

	@Transactional
	public Integer guardarInsumoDTO(InsumoDTO insumoDTO) {
		Integer insumoId = insumoDTO.getId();
		InsumoEntity insumoExistente = null;
		ValorNutricionalEntity valorNutricionalExistente = null;

		if (insumoId == null) {
			insumoExistente = new InsumoEntity();
			valorNutricionalExistente = new ValorNutricionalEntity();
			insumoExistente.setEstado("Activo");
			insumoExistente.setNombre("temp");
			insumoExistente.setValorNutricional(valorNutricionalExistente);
			insumoExistente.setUnidadMedida(unidadMedidaService.buscarPorId(1));
			insumoExistente.setTipoInsumo(tipoInsumoService.buscarPorId(1));

			valorNutricionalExistente.setInsumo(insumoExistente);
			valorNutricionalExistente.setCantidad(100.0);
			valorNutricionalExistente.setUnidadMedida(unidadMedidaService.buscarPorId(1));

			repository.save(insumoExistente);
			valorNutricionalExistente.setId(insumoExistente.getId());
		} else {
			insumoExistente = repository.findById(insumoId)
					.orElseThrow(() -> new RuntimeException("Insumo no encontrado con id: " + insumoId));
			valorNutricionalExistente = insumoExistente.getValorNutricional();
			if (valorNutricionalExistente == null) {
				valorNutricionalExistente = new ValorNutricionalEntity();
				valorNutricionalExistente.setInsumo(insumoExistente);
				insumoExistente.setValorNutricional(valorNutricionalExistente);
				valorNutricionalExistente.setCantidad(100.0);
				valorNutricionalExistente.setUnidadMedida(unidadMedidaService.buscarPorId(1));
			}
		}

		valorNutricionalExistente.setCalorias(insumoDTO.getCalorias());
		valorNutricionalExistente.setProteinas(insumoDTO.getProteinas());
		valorNutricionalExistente.setGrasas(insumoDTO.getGrasas());
		valorNutricionalExistente.setCarbohidratos(insumoDTO.getCarbohidratos());

		insumoExistente.setNombre(insumoDTO.getNombre());
		insumoExistente.setUnidadMedida(unidadMedidaService.buscarPorId(insumoDTO.getUnidadId()));
		insumoExistente.setTipoInsumo(tipoInsumoService.buscarPorId(insumoDTO.getTipoId()));
		insumoExistente.setValorNutricional(valorNutricionalExistente);

		// TODO: perfil nutricional
		repository.save(insumoExistente);

		return insumoExistente.getId();
	}
}

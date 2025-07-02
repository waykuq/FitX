package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.*;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.repository.*;
import org.cibertec.fitx.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecetaServiceImpl extends GenericServiceImpl<RecetaEntity, Integer> implements RecetaService {

	@Autowired
	private EtiquetaRepository etiquetaRepository;

	@Autowired
	private RecetaDetalleRepository detalleRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    private InsumoRepository insumoRepository;



	public RecetaServiceImpl(JpaRepository<RecetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public List<RecetaDTO> listarRecetaDTO() {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findAllWithDetails();
		List<RecetaDTO> temp = recetas.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
		return temp;
	}

	@Override
	public List<RecetaDTO> listarPorUsuarioDTO(Integer usuarioId) {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findVisiblesPorUsuario(usuarioId);
		List<RecetaDTO> temp = recetas.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
		return temp;
	}

	@Override
	@Transactional
	public RecetaDTO buscarRecetaDtoPorId(Integer id) {
		Optional<RecetaEntity> recetaOptional = ((RecetaRepository) repository).findById(id);
		return recetaOptional.map(this::mapearEntidadADto).orElse(null);
	}

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


		// Lista de detalle de insumos
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
						detalleDto.setInsumoCalorias(e.getInsumo().getValorNutricional().getCalorias());
						detalleDto.setInsumoGrasas(e.getInsumo().getValorNutricional().getGrasas());
						detalleDto.setInsumoCarbohidratos(e.getInsumo().getValorNutricional().getCarbohidratos());
						detalleDto.setInsumoProteinas(e.getInsumo().getValorNutricional().getProteinas());
						detalleDto.setUnidadMedidaId(e.getUnidadMedida().getId());
						detalleDto.setUnidadMedidaSimbolo(e.getUnidadMedida().getSimbolo());
						detalleDto.setCantidad(e.getCantidad());
						return detalleDto;
					})
					.collect(Collectors.toSet());
		}
		dto.setDetalles(detallesDTO);

		ValorNutricionalRecetaDTO v = ((RecetaRepository) repository).valorNutricionalRecetaDto(dto.getId());
		dto.setValorNutricional(v);

		return dto;
	}

	@Override
	public RecetaMinDTO mapearEntidadAMinDto(RecetaEntity recetaEntity) {
		if (recetaEntity == null) {
			return null;
		}

		RecetaMinDTO dto = new RecetaMinDTO();
		dto.setId(recetaEntity.getId());
		dto.setNombre(recetaEntity.getNombre());
		return dto;
	}

	@Override
	@Transactional
	public void eliminar(Integer id) {
		Optional<RecetaEntity> recetaOpt = repository.findById(id);

		if (recetaOpt.isPresent()) {
			RecetaEntity receta = recetaOpt.get();
			receta.getEtiquetas().clear();
			repository.delete(receta);
		}
	}

	@Override
	@Transactional
	public void guardarReceta(RecetaDTO recetaActualizadaDTO) {
		Integer recetaId = recetaActualizadaDTO.getId();
		RecetaEntity recetaExistente = null;

		if (recetaId == null) {
			recetaExistente = new RecetaEntity();
			recetaExistente.setFechaCreacion(LocalDate.now());
			UsuarioEntity usuario = usuarioRepository.findById(recetaActualizadaDTO.getUsuarioId())
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
			recetaExistente.setUsuario(usuario);
			recetaExistente.setEstado("Activo");
		} else {
			recetaExistente = repository.findById(recetaId)
					.orElseThrow(() -> new RuntimeException("Receta no encontrada con id: " + recetaId));
		}

		recetaExistente.setNombre(recetaActualizadaDTO.getNombre());
		recetaExistente.setPorciones(recetaActualizadaDTO.getPorciones());
		recetaExistente.setPesoPorcion(recetaActualizadaDTO.getPesoPorcion());
		recetaExistente.setTiempoEstimado(recetaActualizadaDTO.getTiempoEstimado());
		recetaExistente.setFoto(recetaActualizadaDTO.getFoto());
		recetaExistente.setDescripcion(recetaActualizadaDTO.getDescripcion());
		recetaExistente.setUnidadMedida(
				unidadMedidaRepository.findById(recetaActualizadaDTO.getUnidadMedidaId()).get()
		);

		sincronizarEtiquetas(recetaExistente, recetaActualizadaDTO.getEtiquetas());
		sincronizarDetalles(recetaExistente, recetaActualizadaDTO.getDetalles());
		repository.save(recetaExistente);
	}

	private void sincronizarEtiquetas(RecetaEntity receta, Set<EtiquetaMinDTO> etiquetasDTO) {

		if (etiquetasDTO == null) {
			receta.getEtiquetas().clear();
			return;
		}

		// Cargar etiqueta segun los IDs del DTO
		Set<Integer> idsEtiquetasDTO = etiquetasDTO.stream()
				.map(EtiquetaMinDTO::getId)
				.collect(Collectors.toSet());
		Set<EtiquetaEntity> etiquetasReales = new HashSet<>(etiquetaRepository.findAllById(idsEtiquetasDTO));
		receta.setEtiquetas(etiquetasReales);
	}

	private void sincronizarDetalles(RecetaEntity receta, Set<RecetaDetalleDTO> detallesDTO) {
		// Borrar detalles de la receta si viene vacio la list de DTOs
		if (detallesDTO == null) {
			receta.getDetalles().clear();
			return;
		}

		// Mapear detalles del DTO a un Map por ID para fácil acceso (usa 0 o un negativo para los nuevos)
		Map<Integer, RecetaDetalleDTO> detallesDTOMap = detallesDTO.stream()
				.collect(Collectors.toMap(
						d -> (d.getId() != null && d.getId() > -1) ? d.getId() : 0,
						d -> d,
						(d1, d2) -> d1
				));

		// Eliminar o actualizar los detalles existentes
		// Usamos un iterador para poder eliminar elementos de forma segura
		Iterator<RecetaDetalleEntity> iterator = receta.getDetalles().iterator();
		while (iterator.hasNext()) {
			RecetaDetalleEntity detalleExistente = iterator.next();
			RecetaDetalleDTO detalleActualizadoDTO = detallesDTOMap.get(detalleExistente.getId());

			if (detalleActualizadoDTO != null) {
				// El detalle existe en ambos: ACTUALIZARLO
				detalleExistente.setCantidad(detalleActualizadoDTO.getCantidad());
				detalleExistente.setInsumo(insumoRepository.findById(detalleActualizadoDTO.getInsumoId()).get());
				detalleExistente.setUnidadMedida(unidadMedidaRepository.findById(detalleActualizadoDTO.getUnidadMedidaId()).get());
				detallesDTOMap.remove(detalleExistente.getId());
			} else {
				// El detalle existe en la BD pero no en el DTO: ELIMINARLO
				iterator.remove();
			}
		}

		// Añadir los detalles nuevos que quedaron en el map
		for (RecetaDetalleDTO detalleNuevoDTO : detallesDTOMap.values()) {
			RecetaDetalleEntity nuevoDetalle = new RecetaDetalleEntity();
			nuevoDetalle.setCantidad(detalleNuevoDTO.getCantidad());
			nuevoDetalle.setInsumo(
					insumoRepository.findById(
							detalleNuevoDTO.getInsumoId()
					).orElseThrow(
							() -> new RuntimeException("Insumo no encontrado con id: " + detalleNuevoDTO.getInsumoId())
					)
			);
			nuevoDetalle.setUnidadMedida(
					unidadMedidaRepository.findById(
							detalleNuevoDTO.getUnidadMedidaId()
					).orElseThrow(
							() -> new RuntimeException("Insumo no encontrado con id: " + detalleNuevoDTO.getUnidadMedidaId())
					)
			);

			nuevoDetalle.setReceta(receta);
			receta.getDetalles().add(nuevoDetalle);
		}
	}

	public List<RecetaMinDTO> listarRecetasCreadasPorUsuarioMinDto(Integer usuarioId) {
		List<RecetaEntity> recetas = ((RecetaRepository) repository).findByUsuarioId(usuarioId);
		List<RecetaMinDTO> temp = recetas.stream()
				.map(this::mapearEntidadAMinDto)
				.collect(Collectors.toList());
		return temp;
	}

}

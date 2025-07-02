package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.MenuMinDTO;
import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.repository.MenuRepository;
import org.cibertec.fitx.service.MenuService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl extends GenericServiceImpl<MenuEntity, Integer> implements MenuService {

	public MenuServiceImpl(JpaRepository<MenuEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public MenuMinDTO mapearEntidadAMinDto(MenuEntity menu) {
		if (menu == null) return null;
		MenuMinDTO dto = new MenuMinDTO();
		dto.setId(menu.getId());
		dto.setNombre(menu.getNombre());
		dto.setFechaEjecucion(menu.getFechaEjecucion());
		return dto;
	}

	@Override
	public List<MenuMinDTO> listarMenusPorUsuarioMinDto(Integer usuarioId) {
		List<MenuEntity> menusDelUsuario = ((MenuRepository) repository).findByUsuarioId(usuarioId);
		return menusDelUsuario.stream()
				.map(this::mapearEntidadAMinDto)
				.collect(Collectors.toList());
	}
}

package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.MenuMinDTO;
import org.cibertec.fitx.entity.MenuEntity;

import java.util.List;

public interface MenuService extends GenericService<MenuEntity, Integer> {

    public List<MenuMinDTO> listarMenusPorUsuarioMinDto(Integer usuarioId);

    public MenuMinDTO mapearEntidadAMinDto(MenuEntity menu);
}
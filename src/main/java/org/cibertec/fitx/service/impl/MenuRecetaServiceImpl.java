package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.MenuRecetaEntity;
import org.cibertec.fitx.service.MenuRecetaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuRecetaServiceImpl extends GenericServiceImpl<MenuRecetaEntity, Integer> implements MenuRecetaService {

	public MenuRecetaServiceImpl(JpaRepository<MenuRecetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

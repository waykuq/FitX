package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.service.MenuService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends GenericServiceImpl<MenuEntity, Integer> implements MenuService {

	public MenuServiceImpl(JpaRepository<MenuEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

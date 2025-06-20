package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.RecetaFavoritaEntity;
import org.cibertec.fitx.service.RecetaFavoritaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecetaFavoritaServiceImpl extends GenericServiceImpl<RecetaFavoritaEntity, Integer> implements RecetaFavoritaService {

	public RecetaFavoritaServiceImpl(JpaRepository<RecetaFavoritaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

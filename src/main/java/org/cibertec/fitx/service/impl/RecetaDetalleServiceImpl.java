package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.RecetaDetalleEntity;
import org.cibertec.fitx.service.RecetaDetalleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecetaDetalleServiceImpl extends GenericServiceImpl<RecetaDetalleEntity, Integer> implements RecetaDetalleService {

	public RecetaDetalleServiceImpl(JpaRepository<RecetaDetalleEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

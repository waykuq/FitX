package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.service.RecetaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RecetaServiceImpl extends GenericServiceImpl<RecetaEntity, Integer> implements RecetaService {

	public RecetaServiceImpl(JpaRepository<RecetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

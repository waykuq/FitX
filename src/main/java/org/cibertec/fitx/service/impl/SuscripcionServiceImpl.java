package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.SuscripcionEntity;
import org.cibertec.fitx.service.SuscripcionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SuscripcionServiceImpl extends GenericServiceImpl<SuscripcionEntity, Integer> implements SuscripcionService {

	public SuscripcionServiceImpl(JpaRepository<SuscripcionEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

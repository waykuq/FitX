package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.UnidadMedidaEntity;
import org.cibertec.fitx.service.UnidadMedidaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UnidadMedidaServiceImpl extends GenericServiceImpl<UnidadMedidaEntity, Integer> implements UnidadMedidaService {

	public UnidadMedidaServiceImpl(JpaRepository<UnidadMedidaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

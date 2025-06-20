package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.service.EtiquetaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaServiceImpl extends GenericServiceImpl<EtiquetaEntity, Integer> implements EtiquetaService {

	public EtiquetaServiceImpl(JpaRepository<EtiquetaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

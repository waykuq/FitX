package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.service.InsumoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class InsumoServiceImpl extends GenericServiceImpl<InsumoEntity, Integer> implements InsumoService {

	public InsumoServiceImpl(JpaRepository<InsumoEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

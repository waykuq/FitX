package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.TipoInsumoEntity;
import org.cibertec.fitx.service.TipoInsumoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoInsumoServiceImpl extends GenericServiceImpl<TipoInsumoEntity, Integer> implements TipoInsumoService {

	public TipoInsumoServiceImpl(JpaRepository<TipoInsumoEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.TipoUsuarioEntity;
import org.cibertec.fitx.service.TipoUsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioServiceImpl extends GenericServiceImpl<TipoUsuarioEntity, Integer> implements TipoUsuarioService {

	public TipoUsuarioServiceImpl(JpaRepository<TipoUsuarioEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

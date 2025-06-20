package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Integer> implements UsuarioService {

	public UsuarioServiceImpl(JpaRepository<UsuarioEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

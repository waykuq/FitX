package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.PerfilNutricionalEntity;
import org.cibertec.fitx.service.PerfilNutricionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PerfilNutricionalServiceImpl extends GenericServiceImpl<PerfilNutricionalEntity, Integer> implements PerfilNutricionalService {

	public PerfilNutricionalServiceImpl(JpaRepository<PerfilNutricionalEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

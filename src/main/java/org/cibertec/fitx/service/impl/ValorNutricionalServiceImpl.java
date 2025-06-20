package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.entity.ValorNutricionalEntity;
import org.cibertec.fitx.service.ValorNutricionalService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ValorNutricionalServiceImpl extends GenericServiceImpl<ValorNutricionalEntity, Integer> implements ValorNutricionalService {

	public ValorNutricionalServiceImpl(JpaRepository<ValorNutricionalEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}

package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.InsumoDTO;
import org.cibertec.fitx.entity.InsumoEntity;
import org.cibertec.fitx.entity.InsumoEntity;

import java.util.List;

public interface InsumoService extends GenericService<InsumoEntity, Integer> {

    public List<InsumoDTO> listarInsumoDTO();

    public InsumoDTO buscarInsumoDtoPorId(Integer id);

    public InsumoDTO mapearEntidadADto(InsumoEntity etiquetaEntity);

    public Integer guardarInsumoDTO(InsumoDTO insumoDTO);
}
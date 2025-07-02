package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.Reporte1DTO;
import org.cibertec.fitx.dto.Reporte2DTO;

import java.util.List;

public interface ReporteService {

    List<Reporte1DTO> generarReporte1();
    List<Reporte2DTO> generarReporte2();

}

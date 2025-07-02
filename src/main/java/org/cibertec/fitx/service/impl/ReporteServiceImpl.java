package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.*;
import org.cibertec.fitx.entity.MenuEntity;
import org.cibertec.fitx.entity.RecetaEntity;
import org.cibertec.fitx.entity.SuscripcionEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.service.MenuService;
import org.cibertec.fitx.repository.RecetaRepository;
import org.cibertec.fitx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final UsuarioService usuarioService;
    private final MenuService menuService;
    private final RecetaService recetaService;
    private final SuscripcionService suscripcionService;

    @Autowired
    public ReporteServiceImpl(UsuarioService usuarioService, MenuService menuService, RecetaService recetaService, SuscripcionService suscripcionService) {
        this.usuarioService = usuarioService;
        this.menuService = menuService;
        this.recetaService = recetaService;
        this.suscripcionService = suscripcionService;
    }

    @Override
    public List<Reporte1DTO> generarReporte1() {
        List<UsuarioEntity> usuarios = usuarioService.listar();
        List<Reporte1DTO> reportes = new ArrayList<>();

        for(UsuarioEntity usuario : usuarios) {
            Reporte1DTO reporte = new Reporte1DTO();
            reporte.setUsuarioId(usuario.getId());
            reporte.setDni(usuario.getDni());
            reporte.setNombres(usuario.getNombres());
            reporte.setApellidos(usuario.getApellidos());
            reporte.setCorreo(usuario.getCorreo());
            reporte.setTelefono(usuario.getTelefono());
            reporte.setRol(usuario.getTipoUsuario().getNombre());
            reporte.setRolId(usuario.getTipoUsuario().getId());

            List<MenuMinDTO> menus = menuService.listarMenusPorUsuarioMinDto(usuario.getId());
            List<RecetaMinDTO> recetas  = recetaService.listarRecetasCreadasPorUsuarioMinDto(usuario.getId());
            List<SuscripcionMinDTO> suscripciones = suscripcionService.listarSuscripcionPorUsuarioMinDto(usuario.getId());
            reporte.setMenus(menus);
            reporte.setRecetas(recetas);
            reporte.setSuscripciones(suscripciones);

            reporte.setEstadoSuscripcion("Inactivo");
            Optional<SuscripcionMinDTO> suscripcionMasRecienteOpt = suscripciones.stream()
                    .max(Comparator.comparing(SuscripcionMinDTO::getFechaInicio));
            if (suscripcionMasRecienteOpt.isPresent()) {
                SuscripcionMinDTO sus = suscripcionMasRecienteOpt.get();
                reporte.setFechaFinUltimaSuscripcion(sus.getFechaFin());
                reporte.setFechaInicioUltimaSuscripcion(sus.getFechaInicio());
                if (sus.getFechaFin() != null && sus.getFechaFin().isAfter(LocalDate.now())) {
                    reporte.setEstadoSuscripcion("Activo");
                }
            }

//            double sumatoriaTotal = suscripciones.stream()
//                    .mapToDouble(SuscripcionMinDTO::getPrecio)
//                    .sum();

            reportes.add(reporte);
        }
        return reportes;
    }

    @Override
    public List<Reporte2DTO> generarReporte2() {
        List<SuscripcionEntity> suscripciones = suscripcionService.listar();
        List<Reporte2DTO> reportes = new ArrayList<>();

        for(SuscripcionEntity suscripcion : suscripciones) {
            Reporte2DTO reporte = new Reporte2DTO();
            reporte.setUsuarioId(suscripcion.getUsuario().getId());
            reporte.setDni(suscripcion.getUsuario().getDni());
            reporte.setNombre(suscripcion.getUsuario().getNombres() + ' ' +  suscripcion.getUsuario().getApellidos());
            reporte.setFechaInicio(suscripcion.getFechaInicio());
            reporte.setFechaFin(suscripcion.getFechaFin());
            reporte.setPrecio(suscripcion.getPrecio());

            if (reporte.getFechaFin() != null && reporte.getFechaFin().isAfter(LocalDate.now())) {
                reporte.setEstado("Activo");
            } else {
                reporte.setEstado("Inactivo");
            }

            reportes.add(reporte);
        }
        return reportes;
    }
}

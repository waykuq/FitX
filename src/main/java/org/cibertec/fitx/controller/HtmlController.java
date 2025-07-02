package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.Reporte1DTO;
import org.cibertec.fitx.dto.Reporte2DTO;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.EtiquetaEntity;
import org.cibertec.fitx.helper.SesionHelper;
import org.cibertec.fitx.service.ReporteService;
import org.cibertec.fitx.service.TipoUsuarioService;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping({"/web"})
public class HtmlController {

    private final SesionHelper sesionHelper;
    private final ReporteService reporteService;
    private final UsuarioService usuarioService;
    private final TipoUsuarioService tipoUsuarioService;

//    @Autowired
//    private AuthController authController;

    @Autowired
    public HtmlController(SesionHelper sesionHelper, ReporteService reporteService, UsuarioService usuarioService, TipoUsuarioService tipoUsuarioService) {
        this.sesionHelper = sesionHelper;
        this.reporteService = reporteService;
        this.usuarioService = usuarioService;
        this.tipoUsuarioService = tipoUsuarioService;
    }

    private String cargarRol(Model model, HttpSession session) {
        if (!sesionHelper.estaLogueado(session)) {
            //return "login";
            return "redirect:/web/login";
        }
        UsuarioDTO usuario = sesionHelper.obtenerUsuario(session);
        model.addAttribute("rol", usuario.getRolId());

        // TODO: verificar que el usuario tenga permiso de acceso a la pagina
        return null; // sesión válida
    }




    @GetMapping({"/login", "/login/"})
    String login() {
        return "login";
    }

    @GetMapping({"/dashboard", "/dashboard/"})
    String dashboard(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        Integer rol = (Integer) model.getAttribute("rol");
        return (rol != null && rol == 1) ? "dashboard_admin" : "dashboard";
    }

    @GetMapping({"/etiquetas", "/etiquetas/"})
    String etiquetas(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "etiquetas";
    }

    @GetMapping({"/tiposInsumo", "/tiposInsumo/"})
    String tipos_insumo(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "tipos_insumo";
    }

    @GetMapping({"/unidadesMedida", "/unidadesMedida/"})
    String unidades_medida(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "unidad_medida";
    }

    @GetMapping({"/insumos", "/insumos/"})
    String insumos(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "insumo";
    }

    @GetMapping({"/recetas", "/recetas/"})
    String recetas(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "receta";
    }

    @GetMapping({"/recetas/{id}", "/recetas/{id}/"})
    String recetaDetalle(@PathVariable Integer id, Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "receta_detalle";
    }

    @GetMapping({"/recetas/crear", "/recetas/crear/"})
    String recetaCrear(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "receta_detalle";
    }

    @GetMapping({"/menus", "/menus/"})
    String menu(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "menu";
    }

    @GetMapping({"/menus/{id}", "/menus/{id}/"})
    String menuDetalle(@PathVariable Integer id,Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "menu_detalle";
    }

    @GetMapping({"/menus/crear", "/menus/crear/"})
    String menuCrear(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "menu_detalle";
    }

    @GetMapping({"/perfil", "/perfil/"})
    String perfil(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "perfil";
    }

    @GetMapping({"/usuarios", "/usuarios/"})
    String usuarios(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "usuarios";
    }

    @GetMapping({"/suscripciones", "/suscripciones/"})
    String suscripciones(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        return "suscripciones";
    }

    @GetMapping({"/reporte/usuarios", "/reporte/usuarios/"})
    String reporte1(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;
        model.addAttribute("reportes", reporteService.generarReporte1());
        model.addAttribute("usuarios", usuarioService.listarUsuarioDTO());
        model.addAttribute("roles", tipoUsuarioService.listar());
        return "reporte_1";
    }

    @PostMapping({"/reporte/usuarios", "/reporte/usuarios/"})
    String reporte1_filtrado(
            @RequestParam(name = "usuario", required = false)
            Integer usuarioId,
            @RequestParam(name = "rol", required = false)
            Integer rolId,
            @RequestParam(name = "suscripcion", required = false)
            String suscripcionEstado,
            Model model, HttpSession session) {

        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        // filtrar reporte
        List<Reporte1DTO> reportes = reporteService.generarReporte1();
        if (usuarioId > -1) {
            reportes = reportes.stream()
                    .filter(r -> r.getUsuarioId() == usuarioId)
                    .collect(Collectors.toList());
            model.addAttribute("suscripcionSeleccionado", -1);
            model.addAttribute("rolSeleccionado", -1);
            model.addAttribute("usuarioSeleccionado", usuarioId);
        }
        else {
            if (rolId > -1) reportes = reportes.stream()
                    .filter(r -> r.getRolId() != null && r.getRolId().equals(rolId))
                    .collect(Collectors.toList());
            if (!suscripcionEstado.equals("-1")) reportes = reportes.stream()
                    .filter(r -> suscripcionEstado.equalsIgnoreCase(r.getEstadoSuscripcion()))
                    .collect(Collectors.toList());
            model.addAttribute("suscripcionSeleccionado", suscripcionEstado);
            model.addAttribute("rolSeleccionado", rolId);
            model.addAttribute("usuarioSeleccionado", usuarioId);
        }

        model.addAttribute("reportes", reportes);
        model.addAttribute("usuarios", usuarioService.listarUsuarioDTO());
        model.addAttribute("roles", tipoUsuarioService.listar());

        return "reporte_1";
    }

    @GetMapping({"/reporte/suscripciones", "/reporte/suscripciones/"})
    String reporte2(Model model, HttpSession session) {
        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;
        model.addAttribute("reportes", reporteService.generarReporte2());
        model.addAttribute("usuarios", usuarioService.listarUsuarioDTO());
        return "reporte_2";
    }

    @PostMapping({"/reporte/suscripciones", "/reporte/suscripciones/"})
    String reporte2_filtrado(
            @RequestParam(name = "usuario", required = false)
            Integer usuarioId,
            @RequestParam(name = "fechaInicio", required = false)
            String fechaInicioStr,
            @RequestParam(name = "fechaFin", required = false)
            String fechaFinStr,
            @RequestParam(name = "suscripcion", required = false)
            String suscripcionEstado,
            Model model, HttpSession session) {

        String redirect = cargarRol(model, session);
        if (redirect != null) return redirect;

        List<Reporte2DTO> reportes = reporteService.generarReporte2();
        if (usuarioId > -1) reportes = reportes.stream()
                    .filter(r -> r.getUsuarioId() == usuarioId)
                    .collect(Collectors.toList());

        if (!suscripcionEstado.equals("-1")) reportes = reportes.stream()
                .filter(r -> suscripcionEstado.equalsIgnoreCase(r.getEstado()))
                .collect(Collectors.toList());

        if (fechaInicioStr != null && !fechaInicioStr.isBlank()) {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
            reportes = reportes.stream()
                    .filter(r -> !r.getFechaInicio().isBefore(fechaInicio))
                    .collect(Collectors.toList());
        }

        if (fechaFinStr != null && !fechaFinStr.isBlank()) {
            LocalDate fechaFin = LocalDate.parse(fechaFinStr);
            reportes = reportes.stream()
                    .filter(r -> !r.getFechaInicio().isAfter(fechaFin))
                    .collect(Collectors.toList());
        }

        model.addAttribute("suscripcionSeleccionado", suscripcionEstado);
        model.addAttribute("usuarioSeleccionado", usuarioId);
        model.addAttribute("fechaInicioSeleccionado", fechaInicioStr);
        model.addAttribute("fechaFinSeleccionado", fechaFinStr);

        model.addAttribute("reportes", reportes);
        model.addAttribute("usuarios", usuarioService.listarUsuarioDTO());

        return "reporte_2";
    }

}

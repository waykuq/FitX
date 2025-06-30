package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.helper.SesionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/web"})
public class HtmlController {

    private final SesionHelper sesionHelper;

//    @Autowired
//    private AuthController authController;

    @Autowired
    public HtmlController(SesionHelper sesionHelper) {
        this.sesionHelper = sesionHelper;
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

}

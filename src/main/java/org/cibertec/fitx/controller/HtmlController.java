package org.cibertec.fitx.controller;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/web"})
public class HtmlController {

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    String dashboard(HttpSession session) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        if (usuario.getRolId() == 1) return "dashboard_admin";
        else return "dashboard";
    }

    @GetMapping("/etiquetas")
    String etiquetas() {
        return "etiquetas";
    }

    @GetMapping("/tiposInsumo")
    String tipos_insumo() {
        return "tipos_insumo";
    }

    @GetMapping("/unidadesMedida")
    String unidades_medida() {
        return "unidad_medida";
    }

    @GetMapping("/insumos")
    String insumos() {
        return "insumo";
    }

    @GetMapping("/recetas")
    String recetas() {
        return "receta";
    }

    @GetMapping("/recetas/{id}")
    String recetaDetalle(@PathVariable Integer id) {
        return "receta_detalle";
    }

    @GetMapping("/recetas/crear")
    String recetaCrear() {
        return "receta_detalle";
    }



}

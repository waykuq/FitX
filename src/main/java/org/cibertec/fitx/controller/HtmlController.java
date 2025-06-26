package org.cibertec.fitx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/web"})
public class HtmlController {

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

    @GetMapping("/recetas/detalle")
    String recetaDetalle() {
        return "receta_detalle";
    }
}

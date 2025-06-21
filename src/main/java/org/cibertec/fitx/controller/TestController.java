package org.cibertec.fitx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"/web"})
public class TestController {

    @GetMapping("/etiquetas")
    String etiquetas() {
        return "etiquetas";
    }

    @GetMapping("/tiposInsumo")
    String tipos_insumo() {
        return "tipos_insumo";
    }
}

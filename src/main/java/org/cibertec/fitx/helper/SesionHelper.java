package org.cibertec.fitx.helper;

import jakarta.servlet.http.HttpSession;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.springframework.stereotype.Component;

@Component
public class SesionHelper {

    public UsuarioDTO obtenerUsuario(HttpSession session) {
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        return usuario;
    }

    public boolean estaLogueado(HttpSession session) {
        return obtenerUsuario(session) != null;
    }

    public void postRegistroUsuario(UsuarioDTO usuario, HttpSession session) {
        session.setAttribute("usuario", usuario);
    }

}
package org.cibertec.fitx.service;

import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService extends GenericService<UsuarioEntity, Integer> {

    UsuarioEntity autenticar(String correo, String contraseña);

    public List<UsuarioDTO> listarUsuarioDTO();

    public UsuarioDTO buscarUsuarioDtoPorId(Integer id);

    public UsuarioDTO mapearEntidadADto(UsuarioEntity etiquetaEntity);

    public Integer guardarUsuarioDTO(UsuarioDTO usuarioDTO);

}
package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.EtiquetaMinDTO;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.repository.UsuarioRepository;
import org.cibertec.fitx.repository.UsuarioRepository;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Integer> implements UsuarioService {

	public UsuarioServiceImpl(JpaRepository<UsuarioEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

	@Override
	public UsuarioEntity autenticar(String correo, String contraseña) {
		return ((UsuarioRepository) repository).findByCorreoAndContraseña(correo, contraseña).orElse(null);
	}

	public List<UsuarioDTO> listarUsuarioDTO() {
		List<UsuarioEntity> usuarios = ((UsuarioRepository) repository).findAll();
		return usuarios.stream()
				.map(this::mapearEntidadADto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UsuarioDTO buscarUsuarioDtoPorId(Integer id) {
		Optional<UsuarioEntity> usuarioOptional = ((UsuarioRepository) repository).findById(id);
		return usuarioOptional.map(this::mapearEntidadADto).orElse(null);
	}

	@Override
	public UsuarioDTO mapearEntidadADto(UsuarioEntity usuarioEntity) {
		if (usuarioEntity == null) {
			return null;
		}

		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(usuarioEntity.getId());
		dto.setRolId(usuarioEntity.getTipoUsuario().getId());
		dto.setRolNombre(usuarioEntity.getTipoUsuario().getNombre());
		dto.setDni(usuarioEntity.getDni());
		dto.setNombreUsuario(usuarioEntity.getNombreUsuario());
		dto.setNombres(usuarioEntity.getNombres());
		dto.setApellidos(usuarioEntity.getApellidos());
		dto.setCorreo(usuarioEntity.getCorreo());
		dto.setTelefono(usuarioEntity.getTelefono());

		return dto;
	}
}

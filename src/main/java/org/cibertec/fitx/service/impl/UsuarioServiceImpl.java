package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.repository.UsuarioRepository;
import org.cibertec.fitx.service.TipoUsuarioService;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Integer> implements UsuarioService {

	private final TipoUsuarioService tipoUsuarioService;

	@Autowired
	public UsuarioServiceImpl(JpaRepository<UsuarioEntity, Integer> repositorio, TipoUsuarioService tipoUsuarioService) {
		this.repository = repositorio;
		this.tipoUsuarioService = tipoUsuarioService;
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

	@Override
	public Integer guardarUsuarioDTO(UsuarioDTO usuarioDTO) {
		Integer usuarioId = usuarioDTO.getId();
		UsuarioEntity usuarioExistente = null;

		if (usuarioId == null) {
			usuarioExistente = new UsuarioEntity();

			usuarioExistente.setNombres("Temp");
			usuarioExistente.setDni("temp");
			usuarioExistente.setApellidos("Temp");
			usuarioExistente.setCorreo("temp@temp.temp");
			usuarioExistente.setContraseña("temp");
			usuarioExistente.setNombreUsuario(usuarioDTO.getCorreo());

			usuarioExistente.setFechaInscripcion(LocalDate.now());
			usuarioExistente.setEstado("Activo");
			usuarioExistente.setTipoUsuario(tipoUsuarioService.buscarPorId(3));

			repository.save(usuarioExistente);
		} else {
			usuarioExistente = repository.findById(usuarioId)
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));
		}

		usuarioExistente.setNombres(usuarioDTO.getNombres());
		usuarioExistente.setDni(usuarioDTO.getDni());
		usuarioExistente.setApellidos(usuarioDTO.getApellidos());
		usuarioExistente.setCorreo(usuarioDTO.getCorreo());
		usuarioExistente.setContraseña(usuarioDTO.getContraseña());
		usuarioExistente.setTelefono(usuarioDTO.getTelefono());

		// TODO: perfil nutricional
		repository.save(usuarioExistente);

		return usuarioExistente.getId();
	}
}

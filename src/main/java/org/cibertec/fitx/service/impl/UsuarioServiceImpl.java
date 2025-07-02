package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.dto.DietaDto;
import org.cibertec.fitx.dto.UsuarioDTO;
import org.cibertec.fitx.entity.PerfilNutricionalEntity;
import org.cibertec.fitx.entity.UsuarioEntity;
import org.cibertec.fitx.repository.UsuarioRepository;
import org.cibertec.fitx.service.TipoUsuarioService;
import org.cibertec.fitx.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
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

	@Transactional
	@Override
	public Integer guardarUsuarioDTO(UsuarioDTO usuarioDTO) {
		Integer usuarioId = usuarioDTO.getId();
		UsuarioEntity usuarioExistente = null;
//		PerfilNutricionalEntity perfilExistente = null;

		if (usuarioId == null) {
			usuarioExistente = new UsuarioEntity();
			PerfilNutricionalEntity perfilExistente = new PerfilNutricionalEntity();
			usuarioExistente.setPerfilNutricional(perfilExistente);
			perfilExistente.setUsuario(usuarioExistente);
			usuarioExistente.setNombres("Temp");
			usuarioExistente.setDni("temp");
			usuarioExistente.setApellidos("Temp");
			usuarioExistente.setCorreo("temp@temp.temp");
			usuarioExistente.setContraseña("temp");
			usuarioExistente.setNombreUsuario(usuarioDTO.getCorreo());

			usuarioExistente.setFechaInscripcion(LocalDate.now());
			usuarioExistente.setEstado("Activo");
			usuarioExistente.setTipoUsuario(tipoUsuarioService.buscarPorId(3));

//			perfilExistente = new PerfilNutricionalEntity();
//			repository.save(usuarioExistente);
//			perfilExistente.setId(usuarioExistente.getId());
		} else {
			usuarioExistente = repository.findById(usuarioId)
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + usuarioId));
//			perfilExistente = usuarioExistente.getPerfilNutricional();
		}

		usuarioExistente.setNombres(usuarioDTO.getNombres());
		usuarioExistente.setDni(usuarioDTO.getDni());
		usuarioExistente.setApellidos(usuarioDTO.getApellidos());
		usuarioExistente.setCorreo(usuarioDTO.getCorreo());
		usuarioExistente.setContraseña(usuarioDTO.getContraseña());
		usuarioExistente.setTelefono(usuarioDTO.getTelefono());
		usuarioExistente.setNombreUsuario(usuarioDTO.getCorreo());

		PerfilNutricionalEntity perfil = usuarioExistente.getPerfilNutricional();

		if (perfil == null) {
			perfil = new PerfilNutricionalEntity();
			perfil.setUsuario(usuarioExistente);
			usuarioExistente.setPerfilNutricional(perfil);
		}

		perfil.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
		perfil.setPeso(usuarioDTO.getPeso());
		perfil.setTalla(usuarioDTO.getAltura());
		perfil.setNivelActividad(usuarioDTO.getNivel_actividad());
//		perfil.setSexo(usuarioDTO.getSexo());
		String sexoInput = usuarioDTO.getSexo();
		if (sexoInput != null && !sexoInput.isEmpty()) {
			char sexoNormalizado = String.valueOf(sexoInput.trim().charAt(0)).toUpperCase().charAt(0);
			if (sexoNormalizado == 'M' || sexoNormalizado == 'F') {
				perfil.setSexo(sexoNormalizado);
			} else {
				throw new IllegalArgumentException("Valor de sexo no válido: " + sexoInput);
			}
		} else {
			throw new IllegalArgumentException("Valor de sexo no válido: " + sexoInput);
		}




//		usuarioExistente.setPerfilNutricional(perfil);

		repository.save(usuarioExistente);

		return usuarioExistente.getId();
	}

	public DietaDto getDieta(Integer idUsuario) {
		UsuarioEntity usuario = ((UsuarioRepository) repository).findById(idUsuario).orElse(null);

		if (usuario.getPerfilNutricional() != null) {
			DietaDto dieta = new DietaDto();


			int edad = Period.between(usuario.getPerfilNutricional().getFechaNacimiento(), LocalDate.now()).getYears();
			char sexo = usuario.getPerfilNutricional().getSexo();
			double peso = usuario.getPerfilNutricional().getPeso();
			double talla = usuario.getPerfilNutricional().getTalla();

			double tasa_metabolica_basal = 0;

			// Tasa metabólica
			if (edad <= 3) {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 60.9 - 54 : peso * 61.0 - 51;
			} else if (edad <= 10) {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 22.7 + 495 : peso * 22.7 + 499;
			} else if (edad <= 18) {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 17.5 + 651 : peso * 12.2 + 746;
			} else if (edad <= 30) {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 15.3 + 679 : peso * 14.7 + 496;
			} else if (edad <= 60) {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 11.6 + 879 : peso * 8.7 + 829;
			} else {
				tasa_metabolica_basal = (sexo == 'M') ? peso * 13.5 + 487 : peso * 10.5 + 596;
			}

			// Tasa de actividad
			double tasa_actividad = 0;
			String actividad = usuario.getPerfilNutricional().getNivelActividad();

			if (edad <= 12) {
				tasa_actividad = (sexo == 'M') ? 1.75 : 1.64;
			} else if (edad <= 14) {
				tasa_actividad = (sexo == 'M') ? 1.68 : 1.59;
			} else if (edad <= 18) {
				switch (actividad) {
					case "Sedentario":
						tasa_actividad = (sexo == 'M') ? 1.62 : 1.55;
						break;
					case "Moderadamente activo":
						tasa_actividad = (sexo == 'M') ? 1.80 : 1.65;
						break;
					case "Moderado activo":
						tasa_actividad = (sexo == 'M') ? 2.1 : 1.8;
						break;
				}
			} else if (edad <= 65) {
				switch (actividad) {
					case "Sedentario":
						tasa_actividad = (sexo == 'M') ? 1.55 : 1.55;
						break;
					case "Moderadamente activo":
						tasa_actividad = (sexo == 'M') ? 1.80 : 1.65;
						break;
					case "Moderado activo":
						tasa_actividad = (sexo == 'M') ? 2.1 : 1.8;
						break;
				}
			} else {
				switch (actividad) {
					case "Sedentario":
						tasa_actividad = (sexo == 'M') ? 1.4 : 1.4;
						break;
					case "Moderadamente activo":
						tasa_actividad = (sexo == 'M') ? 1.6 : 1.6;
						break;
					case "Moderado activo":
						tasa_actividad = (sexo == 'M') ? 1.9 : 1.8;
						break;
				}
			}

			double valor_calorico_total = tasa_actividad * tasa_metabolica_basal;
			double carbohidratos = valor_calorico_total * 0.6;
			double grasas = valor_calorico_total * 0.25;
			double proteinas = valor_calorico_total * 0.15;

			// Fórmula de Perroult
			double pesoideal = talla - 100 + (edad / 10) * (9 / 10);

			dieta.setCalorias(valor_calorico_total);
			dieta.setCarbohidratos(carbohidratos);
			dieta.setGrasas(grasas);
			dieta.setProteinas(proteinas);
			dieta.setPesoIdeal(pesoideal);

			return dieta;
		} else return null;
	}
}

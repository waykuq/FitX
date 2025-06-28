package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByCorreoAndContraseña(String correo, String contrasena);

}
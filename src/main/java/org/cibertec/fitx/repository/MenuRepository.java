package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {

    List<MenuEntity> findByUsuarioId(Integer usuarioId);



}
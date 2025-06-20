package org.cibertec.fitx.repository;

import org.cibertec.fitx.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
}
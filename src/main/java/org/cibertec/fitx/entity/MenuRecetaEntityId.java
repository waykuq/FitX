package org.cibertec.fitx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class MenuRecetaEntityId implements Serializable {
    private static final long serialVersionUID = -3033622119003992584L;
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(name = "id_receta")
    private Integer idReceta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MenuRecetaEntityId entity = (MenuRecetaEntityId) o;
        return Objects.equals(this.idMenu, entity.idMenu) &&
                Objects.equals(this.idReceta, entity.idReceta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMenu, idReceta);
    }

}
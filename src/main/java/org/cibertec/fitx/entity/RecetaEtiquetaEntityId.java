package org.cibertec.fitx.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class RecetaEtiquetaEntityId implements Serializable {
    private static final long serialVersionUID = -5499212000731722323L;
    @Column(name = "id_etiqueta")
    private Integer idEtiqueta;

    @Column(name = "id_receta")
    private Integer idReceta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RecetaEtiquetaEntityId entity = (RecetaEtiquetaEntityId) o;
        return Objects.equals(this.idEtiqueta, entity.idEtiqueta) &&
                Objects.equals(this.idReceta, entity.idReceta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEtiqueta, idReceta);
    }

}
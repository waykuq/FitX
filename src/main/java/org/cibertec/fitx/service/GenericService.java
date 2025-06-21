package org.cibertec.fitx.service;

import java.util.List;

public interface GenericService<T, ID> {
    T buscarPorId(ID id);
    List<T> listar();
    void crear(T entity);
    void guardar(T entity);
    T guardarGet(T entity);
    void eliminar(ID id);
}
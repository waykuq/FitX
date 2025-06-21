package org.cibertec.fitx.service.impl;

import org.cibertec.fitx.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected JpaRepository<T, ID> repository;

//    public GenericServiceImpl(JpaRepository<T, ID> repository) {
//        this.repository = repository;
//    }

    @Override
    public T buscarPorId(ID id) {
//        return repository.findById(id).get();
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<T> listar() {
        return repository.findAll();
    }

    @Override
    public void crear(T entity) {
        repository.save(entity);
    }

    @Override
    public void guardar(T entity) {
        repository.save(entity);
    }

    @Override
    public T guardarGet(T entity) {
        return repository.save(entity);
    }


    @Override
    public void eliminar(ID id) {
        repository.deleteById(id);
    }
}

package com.ebikecompany.ebikecompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class BaseCrudService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    public T criar(T entity) {
        return getRepository().save(entity);
    }

    public T lerPorId(Integer id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entidade não encontrada."));
    }

    public List<T> lerTodos() {
        return getRepository().findAll();
    }

    public void deletar(Integer id) {
        T entity = lerPorId(id);
        getRepository().delete(entity);
    }
}

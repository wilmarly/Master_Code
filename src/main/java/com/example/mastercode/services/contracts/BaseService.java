package com.example.mastercode.services.contracts;

import com.example.mastercode.entities.common.IdentificableEntity;

import java.util.List;

public interface BaseService<E extends IdentificableEntity> {
    List<E> findAll();

    E findById(Long id);

    <S extends E> E create(S entity);

    <S extends E> E update(Long id, S entity);

    boolean delete(Long id);
}

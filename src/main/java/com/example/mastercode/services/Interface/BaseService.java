package com.example.mastercode.services.Interface;

import java.util.List;

public interface BaseService<E> {
    List<E> findAll();
    E findById(Long id);
    E create(E entity);
    E update(Long id, E entity);
    boolean delete (Long id);
}

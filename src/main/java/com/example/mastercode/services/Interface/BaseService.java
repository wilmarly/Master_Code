package com.example.mastercode.services.Interface;

import java.util.List;

public interface BaseService<E> {
    List<E> findAll() throws Exception;
    E findById(Long id) throws Exception;
    E create(E entity) throws Exception;
    E update(Long id, E entity) throws Exception;
    boolean delete (Long id) throws Exception;
}

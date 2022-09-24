package com.example.mastercode.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping(path = "/default")
public interface BaseController<T> {

    @GetMapping(path = "/all")
    ResponseEntity<List<T>> findAll();

    @GetMapping(path = "/{id}")
    ResponseEntity<T> findById(@PathVariable final Long id);

    @PostMapping(path = "/new")
    ResponseEntity<T> create(@RequestBody final T entity);

    @PutMapping(path = "/{id}")
    ResponseEntity<T> update(@PathVariable final Long id, @RequestBody final T entity);

    @DeleteMapping(path = "/remove")
    ResponseEntity<Boolean> delete(@RequestParam(value = "id") final Long id);
}

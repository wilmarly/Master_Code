package com.example.mastercode.controller;

import com.example.mastercode.dto.RoleDTO;
import com.example.mastercode.services.contracts.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController implements BaseController<RoleDTO> {
    private final BaseService<RoleDTO> service;

    public RoleController(final BaseService<RoleDTO> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<RoleDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<RoleDTO> findById(final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<RoleDTO> create(final RoleDTO entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @Override
    public ResponseEntity<RoleDTO> update(final Long id, final RoleDTO entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @Override
    public ResponseEntity<Boolean> delete(final Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}


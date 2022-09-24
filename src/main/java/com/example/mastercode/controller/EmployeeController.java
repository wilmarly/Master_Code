package com.example.mastercode.controller;

import com.example.mastercode.dto.EmployeeDTO;
import com.example.mastercode.services.contracts.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("employee")
public class EmployeeController implements BaseController<EmployeeDTO> {

    private final BaseService<EmployeeDTO> service;

    public EmployeeController(final BaseService<EmployeeDTO> service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<EmployeeDTO> findById(final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<EmployeeDTO> create(final EmployeeDTO entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @Override
    public ResponseEntity<EmployeeDTO> update(final Long id, final EmployeeDTO entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @Override
    public ResponseEntity<Boolean> delete(final Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}

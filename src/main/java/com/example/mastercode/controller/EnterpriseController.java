package com.example.mastercode.controller;

import com.example.mastercode.dto.EnterpriseDTO;
import com.example.mastercode.services.contracts.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController implements BaseController<EnterpriseDTO> {
    private final BaseService<EnterpriseDTO> service;//Se inyecta la interfase

    public EnterpriseController(final BaseService<EnterpriseDTO> service) {
        this.service = service;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<EnterpriseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnterpriseDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(path = "/new")
    public ResponseEntity<EnterpriseDTO> create(@RequestBody final EnterpriseDTO entity) {
        return ResponseEntity.ok(service.create(entity));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EnterpriseDTO> update(@PathVariable final Long id, @RequestBody final EnterpriseDTO entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping(path = "/remove")
    public ResponseEntity<Boolean> delete(@RequestParam(value = "id") final Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
}

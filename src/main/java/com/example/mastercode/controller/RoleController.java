package com.example.mastercode.controller;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;
import com.example.mastercode.services.Interface.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("role")
public class RoleController {
    private final RoleService instance;

    public RoleController(RoleService instance) {
        this.instance = instance;
    }

    @GetMapping()
    public List<RoleDto> getRoleList() {
        return instance.findAll();
    }

    @PostMapping()
    public Roles createRole(@RequestBody Roles request) {
        return instance.create(request);
    }

    @GetMapping("/{id}")
    public Optional<RoleDto> getRoleId(@PathVariable Long id) {
        return Optional.ofNullable(instance.findById(id));
    }

    @PatchMapping("/{id}")
    public Roles modifyRole(@PathVariable Long id, @RequestBody Roles roles) {
        return instance.update(id, roles);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRole(@PathVariable Long id) {
        return instance.delete(id);
    }
        /*
        @PostMapping
        @GetMapping
        @PatchMapping
        @DeleteMapping
        @PutMapping
        */
}


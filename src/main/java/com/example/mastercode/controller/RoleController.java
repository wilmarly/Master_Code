package com.example.mastercode.controller;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;
import com.example.mastercode.services.RoleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("role")
public class RoleController {
    private final RoleServiceImpl roleServiceImpl;

    public RoleController(RoleServiceImpl roleServiceImpl) {
        this.roleServiceImpl = roleServiceImpl;

    }

    @GetMapping()
    public List<Roles> getRoleList() throws Exception {
        return roleServiceImpl.findAll();
    }

    @PostMapping()
    public Roles createRole(@RequestBody Roles request) throws Exception {
        return roleServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<Roles> getRoleId(@PathVariable Long id) throws Exception {
        return Optional.ofNullable(roleServiceImpl.findById(id));
    }

    @GetMapping("/dto/{id}")
    public RoleDto getRoleDto(@PathVariable Long id) throws Exception {
        return roleServiceImpl.getRoleData(id);
    }

    @PatchMapping("/{id}")
    public Roles modifyRole(@PathVariable Long id, @RequestBody Roles roles) throws Exception {
        return roleServiceImpl.update(id, roles);
    }

    @DeleteMapping("/{id}")
    public boolean deleteRole(@PathVariable Long id) throws Exception {
        return roleServiceImpl.delete(id);
    }
        /*
        @PostMapping
        @GetMapping
        @PatchMapping
        @DeleteMapping
        @PutMapping
        */
}


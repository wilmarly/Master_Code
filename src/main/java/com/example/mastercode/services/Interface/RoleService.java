package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findById(Long id);
    Roles create(Roles entity);
    Roles update(Long id, Roles entity);
    boolean delete (Long id);
    RoleDto getRoleData(Long idRole);
}

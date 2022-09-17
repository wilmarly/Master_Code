package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;

public interface RoleService extends BaseService<Roles>{

    RoleDto getRoleData(Long idRole)throws Exception;
}

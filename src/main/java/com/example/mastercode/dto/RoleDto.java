package com.example.mastercode.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {
    private Long idRole;
    private String role;


    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

package com.example.mastercode.dto;

import java.util.List;

public class RoleDto {
    private Long idRole;
    private String role;

    private List<Long> idEmploy;

    public RoleDto(Long idRole, String role, List<Long> idEmploy) {
        this.idRole = idRole;
        this.role = role;
        this.idEmploy = idEmploy;
    }

    public RoleDto() {

    }

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

    public List<Long> getIdEmploy() {
        return idEmploy;
    }

    public void setIdEmploy(List<Long> idEmploy) {
        this.idEmploy = idEmploy;
    }
}

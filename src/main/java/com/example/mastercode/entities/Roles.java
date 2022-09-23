package com.example.mastercode.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;//roll id
    @Column(name = "role")
    private String role;//rol

    public Roles(Long idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    public Roles() {

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
/*
    @Override
    public String toString() {
        return "Roles{" + "idRole=" + idRole + ", role='" + role + '\'' + '}';
    }*/
}

package com.example.mastercode.entities;

import com.example.mastercode.entities.common.IdentificableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "roles", schema = "crudexample")
public class Role implements Serializable, IdentificableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//roll id
    @Column(name = "name")
    private String name;//rol

    public Role() {
        //default
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long idRole) {
        this.id = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String role) {
        this.name = role;
    }

    @Override
    public String toString() {
        return "Roles{" + "idRole=" + id + ", role='" + name + '\'' + '}';
    }
}

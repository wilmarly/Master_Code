package com.example.mastercode.dto;

import com.example.mastercode.entities.common.IdentificableEntity;

import java.io.Serializable;

public record RoleDTO(Long id, String name) implements Serializable, IdentificableEntity {

    public static RoleDTO create(Long id, String name) {
        return new RoleDTO(id, name);
    }

}

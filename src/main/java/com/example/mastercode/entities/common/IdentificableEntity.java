package com.example.mastercode.entities.common;

public interface IdentificableEntity {

    default Long getId() {
        throw new UnsupportedOperationException("Not Implemented");
    }

    default void setId(Long id) {
        throw new UnsupportedOperationException("Not Implemented");
    }

}

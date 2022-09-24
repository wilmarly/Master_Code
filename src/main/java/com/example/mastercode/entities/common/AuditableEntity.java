package com.example.mastercode.entities.common;


import com.example.mastercode.entities.embedded.Auditable;

public interface AuditableEntity {

    Auditable getAuditable();

    void setAuditable(Auditable auditable);
}

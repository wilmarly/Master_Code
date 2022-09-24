package com.example.mastercode.entities.listener;

import com.example.mastercode.entities.common.AuditableEntity;
import com.example.mastercode.entities.embedded.Auditable;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class AuditableListener {


    @PrePersist
    public void setCreatedAt(AuditableEntity auditableEntity) {
        var auditable = auditableEntity.getAuditable();
        if (auditable == null) {
            auditable = new Auditable();
            auditableEntity.setAuditable(auditable);
        }
        auditable.setCreatedAt(LocalDate.now());
    }

    @PreUpdate
    public void setUpdatedAt(AuditableEntity auditableEntity) {
        auditableEntity.getAuditable().setUpdatedAt(LocalDate.now());
    }
}

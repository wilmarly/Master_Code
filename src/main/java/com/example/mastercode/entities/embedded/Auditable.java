package com.example.mastercode.entities.embedded;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class Auditable implements Serializable {

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}

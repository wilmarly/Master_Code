package com.example.mastercode.dto;

import com.example.mastercode.entities.common.IdentificableEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@JsonDeserialize(builder = EnterpriseDTO.Builder.class)
public class EnterpriseDTO implements Serializable, IdentificableEntity {
    private final Long id;
    private final String name;
    private final String nit;
    private final String phone;
    private final String address;
    private final List<Long> transactionIds;
    private final List<String> employees;//names
    private final LocalDate createdAt;
    private final LocalDate updatedAt;

    private EnterpriseDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.nit = builder.nit;
        this.phone = builder.phone;
        this.address = builder.address;
        this.transactionIds = new ArrayList<>(builder.transactionIds);
        this.employees = new ArrayList<>(builder.employees);
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getNit() {
        return nit;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<Long> getTransactionIds() {
        return transactionIds;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public Long getId() {
        return id;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {

        private final Collection<Long> transactionIds = new LinkedList<>();
        private final Collection<String> employees = new LinkedList<>();
        private Long id;
        private String name;
        private String nit;
        private String phone;
        private String address;
        private LocalDate createdAt;
        private LocalDate updatedAt;

        public EnterpriseDTO build() {
            return new EnterpriseDTO(this);
        }

        public Builder setId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setNit(final String nit) {
            this.nit = nit;
            return this;
        }

        public Builder setPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder setTransactionIds(final Collection<Long> transactionIds) {
            this.transactionIds.clear();
            this.transactionIds.addAll(transactionIds);
            return this;
        }

        public Builder setEmployees(final Collection<String> employees) {
            this.employees.clear();
            this.employees.addAll(employees);
            return this;
        }

        public Builder setCreatedAt(final LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(final LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
    }
}

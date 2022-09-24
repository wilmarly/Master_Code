package com.example.mastercode.dto;

import com.example.mastercode.entities.common.IdentificableEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonDeserialize(builder = EmployeeDTO.Builder.class)
public class EmployeeDTO implements Serializable, IdentificableEntity {

    private final Long id;
    private final String name;
    private final String lastName;
    private final int age;
    private final String enterpriseNit;
    private final String phone;
    private final String email;
    private final List<Long> transactionIds;
    private final Set<String> roles;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;

    private EmployeeDTO(EmployeeDTO.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.enterpriseNit = builder.enterprise;
        this.phone = builder.phone;
        this.email = builder.email;
        this.transactionIds = List.copyOf(builder.transactionIds);
        this.roles = Set.copyOf(builder.roles);
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;

    }

    public static Builder builder() {
        return new Builder();
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEnterpriseNit() {
        return enterpriseNit;
    }


    public String getPhone() {
        return phone;
    }

    public List<Long> getTransactionIds() {
        return transactionIds;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public String getEmail() {
        return email;
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        private final Set<String> roles = new HashSet<>();
        private final List<Long> transactionIds = new ArrayList<>();
        private int age;
        private String email;
        private Long id;
        private String name;
        private String lastName;
        private String enterprise;

        private String phone;
        private LocalDate createdAt;
        private LocalDate updatedAt;

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }

        public Builder setId(final Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(final String name) {
            this.name = name;
            return this;
        }

        public Builder setEnterprise(final String enterprise) {
            this.enterprise = enterprise;
            return this;
        }


        public Builder setPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setTransactionIds(final List<Long> transactionIds) {
            this.transactionIds.clear();
            this.transactionIds.addAll(transactionIds);
            return this;
        }

        public Builder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }


        public Builder setCreatedAt(final LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setRoles(List<String> roles) {
            this.roles.clear();
            this.roles.addAll(roles);
            return this;
        }

        public Builder setUpdatedAt(final LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setAge(final int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(final String email) {
            this.email = email;
            return this;
        }
    }
}

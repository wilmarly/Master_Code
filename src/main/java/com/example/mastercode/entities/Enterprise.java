package com.example.mastercode.entities;

import com.example.mastercode.entities.common.AuditableEntity;
import com.example.mastercode.entities.common.IdentificableEntity;
import com.example.mastercode.entities.embedded.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"transactionList", "employeesList"})
@Table(name = "enterprises", schema = "crudexample")
public class Enterprise implements Serializable, IdentificableEntity, AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //enterprise id
    @Column(name = "name")
    private String name;//enterprise name
    @Column(name = "nit", unique = true, nullable = false)
    @NaturalId
    private String nit;//enterprise nit
    @Column(name = "phone")
    private String phone;//enterprise phone
    @Column(name = "address")
    private String address;//enterprise address

    @Embedded
    private Auditable auditable;

    public Enterprise() {
        //default
    }

    @Override
    public Auditable getAuditable() {
        return auditable;
    }

    @Override
    public void setAuditable(final Auditable auditable) {
        this.auditable = auditable;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long idEnterprise) {
        this.id = idEnterprise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}



package com.example.mastercode.entities;

import com.example.mastercode.entities.common.AuditableEntity;
import com.example.mastercode.entities.common.IdentificableEntity;
import com.example.mastercode.entities.embedded.Auditable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "profiles", schema = "crudexample")
public class Profile implements Serializable, IdentificableEntity, AuditableEntity {
    @Id
    private Long id;//profile id
    @Column(name = "name")
    private String name;//profile name
    @Column(name = "last_name")
    private String lastName;//profile last name
    @Column(name = "age")
    private Integer age;//profile age
    @Column(name = "phone")
    private String phone;//profile phone

    @Embedded
    private Auditable auditable;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Profile() {
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}

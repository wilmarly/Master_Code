package com.example.mastercode.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties("employee")
@Table(name = "Profiles")
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfile;//profile id
    @Column(name = "name")
    private String name;//profile name
    @Column(name = "last_name")
    private String lastName;//profile last name
    @Column(name = "age")
    private Integer age;//profile age
    @Column(name = "phone")
    private String phone;//profile phone
    @OneToOne(mappedBy = "profile")
    private Employee employee;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDate created_at;//profile created date
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDate updated_at;//profile updated date

    public Profile(String name, String lastName, Integer age, String phone,Employee employee, LocalDate created_at, LocalDate updated_at) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.employee= employee;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Profile() {

    }

    public Long getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Long id) {
        this.idProfile = id;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

}

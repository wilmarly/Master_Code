package com.example.mastercode.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties("transaction")
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;//Employer id
    @Column(name = "email")
    private String email;//Employer email
    @OneToOne
    @JoinColumn(name = "id_role")
    private Roles roles;//Employer roles
    @OneToOne
    @JoinColumn(name = "id_profile",unique = true)
    private Profile profile;//Employer profile
    @ManyToOne
    @JoinColumn(name = "id_enterprice")
    private Enterprise enterprise;//Employer enterprice
    @OneToMany(mappedBy = "employee")
    private List<Transaction> transaction;
    @Column(name = "created_at")
    private LocalDate created_at;//Employer created date
    @Column(name = "updated_at")
    private LocalDate updated_at;//Employer updated date

    public Employee(String email, Roles roles, Profile profile, Enterprise enterprise, LocalDate created_at, LocalDate updated_at) {// se puede retirar el argumento de id; List<Transaction> transaction,
        this.email = email;
        this.roles = roles;
        this.profile = profile;
        this.enterprise = enterprise;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Employee() {

    }

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Roles getRole() {
        return roles;
    }

    public void setRole(Roles roles) {
        this.roles = roles;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
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
        
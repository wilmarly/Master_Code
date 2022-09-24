package com.example.mastercode.entities;

import com.example.mastercode.entities.common.AuditableEntity;
import com.example.mastercode.entities.common.IdentificableEntity;
import com.example.mastercode.entities.embedded.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties("transaction")
@Table(name = "employees", schema = "crudexample")
public class Employee implements Serializable, IdentificableEntity, AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;//Employer id
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "employee_role", schema = "crudexample",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles = new LinkedHashSet<>();

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Profile profile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enterprise", foreignKey = @ForeignKey(name = "enterprise_fk"))
    private Enterprise enterprise;

    @Embedded
    private Auditable auditable;

    public Employee() {
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(final Profile profile) {
        if (profile == null) {
            if (this.profile != null) {
                this.profile.setEmployee(null);
            }
        } else {
            profile.setEmployee(this);
        }
        this.profile = profile;
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long idEmployee) {
        this.id = idEmployee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(final Set<Role> roles) {
        this.roles = roles;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

}

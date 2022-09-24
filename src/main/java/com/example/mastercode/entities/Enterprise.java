package com.example.mastercode.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIgnoreProperties({"transactionList","employeesList"})
@Table(name = "Enterprices")
public class Enterprise implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY

    )
    private Long idEnterprise; //enterprise id
    @Column(name = "name")
    private String name;//enterprise name
    @Column(name = "nit")
    private String nit;//enterprise nit
    @Column(name = "phone")
    private String phone;//enterprise phone
    @Column(name = "address")
    private String address;//enterprise address
    @OneToMany(mappedBy = "enterprise")
    private List<Employee> employeesList;//enterprise employee
    @Column(name = "created_at")
    private LocalDate created_at;  // transaction created date
    @Column(name = "updated_at")
    private LocalDate updated_at; // transacción updated date

    public Enterprise(String name, String nit, String phone, String address, LocalDate created_at, LocalDate updated_at) {
        this.name = name;
        this.nit = nit;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Enterprise() {

    }

    public Long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(Long idEnterprise) {
        this.idEnterprise = idEnterprise;
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

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
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



package com.example.mastercode.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EnterpriseDto implements Serializable {
    private Long idEnterprise;
    private String name;
    private String nit;
    private String phone;
    private String address;
    private List<Long> transactionList;
    private List<String> employeesList;
    private LocalDate created_at;
    private LocalDate updated_at;


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

    public List<Long> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Long> transactionList) {
        this.transactionList = transactionList;
    }

    public List<String> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<String> employeesList) {
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

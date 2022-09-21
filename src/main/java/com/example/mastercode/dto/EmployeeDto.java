package com.example.mastercode.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDto implements Serializable {

    private Long idEmployee;
    private String employeeName;
    private String enterpriseName;
    private String role;
    private String phone;
    private List<Long> idTransaction;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Long> getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(List<Long> idTransaction) {
        this.idTransaction = idTransaction;
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

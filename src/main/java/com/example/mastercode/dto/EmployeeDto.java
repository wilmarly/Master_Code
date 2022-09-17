package com.example.mastercode.dto;

import java.util.List;

public class EmployeeDto {

    private Long idEmployee;
    private String employeeName;
    private String enterpriseName;
    private String role;
    private List<Long> idTransaccion;

    public EmployeeDto() {
    }

    public EmployeeDto(Long idEmployee, String employeeName, String enterpriseName, String role, List<Long> idTransaccion) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.enterpriseName = enterpriseName;
        this.role = role;
        this.idTransaccion = idTransaccion;
    }

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

    public List<Long> getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(List<Long> idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}

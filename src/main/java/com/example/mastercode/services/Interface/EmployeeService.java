package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto findById(Long idEmployee);
    String create(Employee entity);
    Employee update(Long id, Employee entity);
    boolean delete(Long id);

}

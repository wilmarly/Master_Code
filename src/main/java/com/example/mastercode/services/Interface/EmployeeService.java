package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto findById(Long idEmployee);
    Employee create(Employee entity);
    Employee update(Long id, Employee entity);
    Employee updateOnce(Long id, Map<Object,Object> objectMap);
    boolean delete(Long id);

}

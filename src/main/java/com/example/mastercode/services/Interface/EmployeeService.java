package com.example.mastercode.services.Interface;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;

public interface EmployeeService extends BaseService<Employee>{
    EmployeeDto getEmployeeData(Long idEmployee)throws Exception;

}

package com.example.mastercode.services;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.repositories.EmployeeRepository;
import com.example.mastercode.services.Interface.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    private EmployeeDto convertEntityDto(Employee employee) {

        Optional<Employee> employees = employeeRepository.findById(employee.getIdEmployee());
        List<Long> idTransactions = new ArrayList<>();
        employees.get().getTransaction().forEach((t) -> {
            idTransactions.add(t.getIdTransaction());
        });

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setIdEmployee(employee.getIdEmployee());
        employeeDto.setEmployeeName(employee.getProfile().getName());
        employeeDto.setEnterpriseName(employee.getEnterprise().getName());
        employeeDto.setRole(employee.getRole().getRole());
        employeeDto.setPhone(employee.getProfile().getPhone());
        employeeDto.setIdTransaction(idTransactions);
        employeeDto.setCreated_at(employee.getCreated_at());
        employeeDto.setUpdated_at(employee.getUpdated_at());

        return employeeDto;
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long idEmployee) {

        Optional<Employee> employee = employeeRepository.findById(idEmployee);
        List<Long> idTransactions = new ArrayList<>();
        employee.get().getTransaction().forEach((t) -> {
            idTransactions.add(t.getIdTransaction());
        });

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setIdEmployee(employee.get().getIdEmployee());
        employeeDto.setEmployeeName(employee.get().getProfile().getName());
        employeeDto.setEnterpriseName(employee.get().getEnterprise().getName());
        employeeDto.setRole(employee.get().getRole().getRole());
        employeeDto.setPhone(employee.get().getProfile().getPhone());
        employeeDto.setIdTransaction(idTransactions);
        employeeDto.setCreated_at(employee.get().getCreated_at());
        employeeDto.setUpdated_at(employee.get().getUpdated_at());

        return employeeDto;

    }

    @Override
    public Employee create(Employee entity) {

        return employeeRepository.save(entity);
    }

    @Override
    public Employee update(Long id, Employee entity) {


        Optional<Employee> employeeUpdate = employeeRepository.findById(id);
        Employee employee = employeeUpdate.get();


        if(entity.getEmail() != null){
            employee.setEmail(entity.getEmail());
        }
        if(entity.getRole() != null){
            employee.setRole(entity.getRole());
        }
        if(entity.getProfile() != null){
            employee.setProfile(entity.getProfile());
        }
        if(entity.getEnterprise() != null){
            employee.setEnterprise(entity.getEnterprise());
        }
        if(entity.getCreated_at() != null){
            employee.setCreated_at(entity.getCreated_at());
        }
        if(entity.getUpdated_at() != null){
            employee.setUpdated_at(entity.getUpdated_at());
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateOnce(Long id, Map<Object, Object> objectMap) {

        Employee employeeUpdate = employeeRepository.findById(id).get();

        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Employee.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, employeeUpdate, value);
        });

        return employeeRepository.save(employeeUpdate);

    }

    @Override
    public boolean delete(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }


}

package com.example.mastercode.services;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.repositories.EmployeeRepository;
import com.example.mastercode.services.Interface.EmployeeService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        return convertEntityDto(employeeRepository.findById(idEmployee).get());
    }

    @Override
    public String create(Employee entity) {


        try {
            employeeRepository.save(entity);
            return "Usuario creado correctamente";

        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityViolationException("El perfil ya esta asignado a un empleado");
        }

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
    public boolean delete(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}

package com.example.mastercode.services;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.repositories.EmployeeRepository;
import com.example.mastercode.services.Interface.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() throws Exception {

        try {

            List<Employee> entities = employeeRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Employee findById(Long id) throws Exception {

        try {
            Optional<Employee> entityOptional = employeeRepository.findById(id);
            return entityOptional.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Employee create(Employee entity) throws Exception {

        try {
            entity = employeeRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Employee update(Long id, Employee entity) throws Exception {

        try {
            Optional<Employee> employeeOptional = employeeRepository.findById(id);
            Employee employeeUpdate = employeeOptional.get();
            employeeUpdate = employeeRepository.save(entity);
            return employeeUpdate;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    /*    @Transactional*/
    public boolean delete(Long id) throws Exception {

        try {
            if (employeeRepository.existsById(id)) {
                employeeRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public EmployeeDto getEmployeeData(Long idEmployee)throws Exception {

        try {
            Optional<Employee> employee = employeeRepository.findById(idEmployee);

            List<Long> idTransactions = new ArrayList<>();

            employee.get().getTransaction().forEach((t)->{
                idTransactions.add(t.getIdTransaction());
            });

            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setIdEmployee(employee.get().getIdEmployee());
            employeeDto.setEmployeeName(employee.get().getProfile().getName());
            employeeDto.setEnterpriseName(employee.get().getEnterprise().getName());
            employeeDto.setRole(employee.get().getRole().getRole());
            employeeDto.setIdTransaccion(idTransactions);

            return employeeDto;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

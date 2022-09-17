package com.example.mastercode.controller;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping()
    public List<Employee> getEmployeeList() throws Exception {
        return employeeServiceImpl.findAll();
    }

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee request) throws Exception {
        return employeeServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeId(@PathVariable Long id) throws Exception {
        return Optional.ofNullable(employeeServiceImpl.findById(id));
    }

    @GetMapping("/dto/{id}")
    public EmployeeDto getEmployeeDto(@PathVariable Long id) throws Exception {
        return employeeServiceImpl.getEmployeeData(id);
    }

    @PatchMapping("/{id}")
    public Employee modifyEmployee(@PathVariable Long id, @RequestBody Employee employee) throws Exception {
        return employeeServiceImpl.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) throws Exception {
        return employeeServiceImpl.delete(id);
    }
/*
        @PostMapping : Crear un recurso nuevo
        @GetMapping : Consultar informacion de un recurso
        @PatchMapping : Modificar solamente un atributo
        @DeleteMapping : Eliminar un recurso determinado
        @PutMapping : modificar un recurso existente
*/
}

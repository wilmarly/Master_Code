package com.example.mastercode.controller;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.services.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    public List<EmployeeDto> getEmployeeList(){
        return employeeServiceImpl.findAll();
    }

    @PostMapping()
    public Employee createEmployee(@RequestBody Employee request){
        return employeeServiceImpl.create(request);
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDto> getEmployeeId(@PathVariable Long id)  {
        return Optional.ofNullable(employeeServiceImpl.findById(id));
    }

    @GetMapping("/dto/{id}")
    public EmployeeDto getEmployeeDto(@PathVariable Long id) {
        return employeeServiceImpl.findById(id);
    }

    @PatchMapping("/{id}")
    public Employee modifyEmployee(@PathVariable Long id, @RequestBody Employee entity) {
        return employeeServiceImpl.update(id, entity);
    }

    @PatchMapping("/camp/{id}")
    public Employee modifyEmployee2(@PathVariable Long id, @RequestBody Map<Object, Object> objectMap) {
        return employeeServiceImpl.updateOnce(id, objectMap);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
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

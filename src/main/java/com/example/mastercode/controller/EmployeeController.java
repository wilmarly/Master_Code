package com.example.mastercode.controller;

import com.example.mastercode.dto.EmployeeDto;
import com.example.mastercode.dto.GeneralResponse;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.services.Interface.EmployeeService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/rest/employee")
public class EmployeeController {

    private final EmployeeService instance;

    public EmployeeController(EmployeeService instance) {
        this.instance = instance;
    }

    @GetMapping()
    public List<EmployeeDto> getEmployeeList(){
        return instance.findAll();
    }

    @PostMapping()
    public ResponseEntity createEmployee(@RequestBody Employee request){
        GeneralResponse generalResponse = new GeneralResponse();

        generalResponse.setDate(LocalDate.now());

        try {
            generalResponse.setStatus("ok");
            generalResponse.setMessage(instance.create(request));

            return ResponseEntity.ok(generalResponse);
        }catch (DataIntegrityViolationException e){
            generalResponse.setStatus("BadRequest");
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }

    }

    @GetMapping("/{id}")
    public Optional<EmployeeDto> getEmployeeId(@PathVariable Long id)  {
        return Optional.ofNullable(instance.findById(id));
    }
    @PatchMapping("/{id}")
    public Employee modifyEmployee(@PathVariable Long id, @RequestBody Employee entity) {
        return instance.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable Long id) {
        return instance.delete(id);
    }
/*
        @PostMapping : Crear un recurso nuevo
        @GetMapping : Consultar informacion de un recurso
        @PatchMapping : Modificar solamente un atributo
        @DeleteMapping : Eliminar un recurso determinado
        @PutMapping : modificar un recurso existente
*/
}

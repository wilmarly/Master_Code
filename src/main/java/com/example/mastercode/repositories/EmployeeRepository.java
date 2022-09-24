package com.example.mastercode.repositories;

import com.example.mastercode.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByProfileName(String name);
}

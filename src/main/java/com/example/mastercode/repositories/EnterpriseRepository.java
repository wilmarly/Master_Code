package com.example.mastercode.repositories;


import com.example.mastercode.entities.Enterprise;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    @EntityGraph(attributePaths = "employees")
    Optional<Enterprise> findByNit(String nit);

}

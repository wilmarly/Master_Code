package com.example.mastercode.repositories;

import com.example.mastercode.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Set<Role> findAllByNameIn(Set<String> names);
}

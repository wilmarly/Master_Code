package com.example.mastercode.services.mapper;

import com.example.mastercode.dto.EmployeeDTO;
import com.example.mastercode.dto.EnterpriseDTO;
import com.example.mastercode.dto.RoleDTO;
import com.example.mastercode.dto.TransactionDTO;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Profile;
import com.example.mastercode.entities.Role;
import com.example.mastercode.entities.Transaction;

public class EntityMapper {

    public TransactionDTO transactionDTO(Transaction transaction) {
        return new TransactionDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getConcept(),
                transaction.getEmployee().getEnterprise().getNit(),
                transaction.getEmployee().getProfile().getName(),
                transaction.getAuditable().getCreatedAt(),
                transaction.getAuditable().getUpdatedAt()
        );
    }

    public Transaction newTransaction(TransactionDTO transactionDTO) {
        var entity = new Transaction();
        entity.setId(transactionDTO.id());
        entity.setAmount(transactionDTO.amount());
        entity.setConcept(transactionDTO.concept());
        return entity;
    }

    public RoleDTO roleDTO(Role role) {
        return RoleDTO.create(role.getId(), role.getName());
    }

    public Role newRole(RoleDTO roleDTO) {
        var role = new Role();
        role.setId(roleDTO.id());
        role.setName(roleDTO.name());
        return role;
    }

    public EmployeeDTO employeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                          .setId(employee.getId())
                          .setName(employee.getProfile().getName())
                          .setLastName(employee.getProfile().getLastName())
                          .setAge(employee.getProfile().getAge())
                          .setEnterprise(employee.getEnterprise().getNit())
                          .setPhone(employee.getProfile().getPhone())
                          .setEmail(employee.getEmail())
                          .setCreatedAt(employee.getAuditable().getCreatedAt())
                          .setUpdatedAt(employee.getAuditable().getUpdatedAt())
                          .build();
    }

    public Employee newEmployee(EmployeeDTO employeeDTO) {
        var profile = new Profile();
        profile.setName(employeeDTO.getName());
        profile.setLastName(employeeDTO.getLastName());
        profile.setAge(employeeDTO.getAge());
        profile.setPhone(employeeDTO.getPhone());

        var entity = new Employee();
        entity.setId(employeeDTO.getId());
        entity.setEmail(employeeDTO.getEmail());
        entity.setProfile(profile);
        return entity;
    }

    public Enterprise newEnterprise(EnterpriseDTO enterpriseDTO) {
        var entity = new Enterprise();
        entity.setId(enterpriseDTO.getId());
        entity.setNit(enterpriseDTO.getNit());
        entity.setName(enterpriseDTO.getName());
        entity.setPhone(enterpriseDTO.getPhone());
        entity.setAddress(enterpriseDTO.getAddress());
        return entity;
    }

    public EnterpriseDTO enterpriseDTO(Enterprise enterprise) {
        return EnterpriseDTO.builder()
                            .setId(enterprise.getId())
                            .setName(enterprise.getName())
                            .setNit(enterprise.getNit())
                            .setPhone(enterprise.getPhone())
                            .setAddress(enterprise.getAddress())
                            .setCreatedAt(enterprise.getAuditable().getCreatedAt())
                            .setUpdatedAt(enterprise.getAuditable().getUpdatedAt())
                            .build();
    }

}

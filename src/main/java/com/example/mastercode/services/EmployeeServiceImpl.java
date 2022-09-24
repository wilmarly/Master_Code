package com.example.mastercode.services;

import com.example.mastercode.dto.EmployeeDTO;
import com.example.mastercode.repositories.EmployeeRepository;
import com.example.mastercode.repositories.EnterpriseRepository;
import com.example.mastercode.repositories.RoleRepository;
import com.example.mastercode.services.contracts.BaseService;
import com.example.mastercode.services.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements BaseService<EmployeeDTO> {

    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;
    private final EntityMapper mapper;
    private final EnterpriseRepository enterpriseRepository;

    public EmployeeServiceImpl(final EmployeeRepository employeeRepository,
                               RoleRepository roleRepository,
                               EnterpriseRepository enterpriseRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.mapper = new EntityMapper();
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll()
                                 .stream()
                                 .map(mapper::employeeDTO)
                                 .toList();
    }

    @Override
    public EmployeeDTO findById(final Long id) {
        return employeeRepository.findById(id)
                                 .map(mapper::employeeDTO)
                                 .orElseThrow();
    }

    @Override
    public <S extends EmployeeDTO> EmployeeDTO create(final S entity) {
        var employee = mapper.newEmployee(entity);
        var roles = roleRepository.findAllByNameIn(entity.getRoles());
        employee.setRoles(roles);
        var enterprise = enterpriseRepository.findByNit(entity.getEnterpriseNit())
                                             .orElseThrow(() -> new NoSuchElementException("Enterprise not found"));
        employee.setEnterprise(enterprise);
        var savedEmployee = employeeRepository.save(employee);
        return mapper.employeeDTO(savedEmployee);
    }

    @Override
    public <S extends EmployeeDTO> EmployeeDTO update(final Long id, final S entity) {
        return employeeRepository.findById(id)
                                 .map(employee -> {
                                     var profile = employee.getProfile();
                                     profile.setName(entity.getName());
                                     profile.setLastName(entity.getLastName());
                                     profile.setAge(entity.getAge());
                                     profile.setPhone(entity.getPhone());

                                     employee.setId(entity.getId());
                                     employee.setEmail(entity.getEmail());
                                     employee.setProfile(profile);
                                     return employeeRepository.save(employee);
                                 })
                                 .map(mapper::employeeDTO)
                                 .orElseThrow();
    }

    @Override
    public boolean delete(final Long id) {
        employeeRepository.deleteById(id);
        return employeeRepository.existsById(id);
    }
}

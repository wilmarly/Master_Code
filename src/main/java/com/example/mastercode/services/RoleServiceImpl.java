package com.example.mastercode.services;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;
import com.example.mastercode.repositories.RoleRepository;
import com.example.mastercode.services.Interface.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    //create role class object

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private RoleDto convertEntityDto(Roles role){
        RoleDto roleDto = new RoleDto();

        roleDto.setIdRole(role.getIdRole());
        roleDto.setRole(role.getRole());

        return roleDto;
    }

    @Override
    public List<RoleDto> findAll() {


        return roleRepository.findAll()
                .stream()
                .map(this::convertEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(Long idRole) {

        return convertEntityDto(roleRepository.findById(idRole).get());
    }

    @Override
    public Roles create(Roles entity) {

        entity = roleRepository.save(entity);
        return entity;
    }

    @Override
    public Roles update(Long id, Roles entity) {

        Optional<Roles> roleUpdate = roleRepository.findById(id);

        Roles role = roleUpdate.get();

        if(entity.getRole() != null){
            role.setRole(entity.getRole());
        }

        return roleRepository.save(role);
    }

    @Override
    public boolean delete(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

}

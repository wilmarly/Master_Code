package com.example.mastercode.services;

import com.example.mastercode.dto.RoleDTO;
import com.example.mastercode.repositories.RoleRepository;
import com.example.mastercode.services.contracts.BaseService;
import com.example.mastercode.services.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements BaseService<RoleDTO> {

    //create role class object

    private final RoleRepository roleRepository;
    private final EntityMapper mapper;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
        this.mapper = new EntityMapper();
    }


    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll().stream().map(mapper::roleDTO).toList();
    }

    @Override
    public RoleDTO findById(final Long id) {
        return roleRepository.findById(id)
                             .map(mapper::roleDTO)
                             .orElseThrow();
    }

    @Override
    public <S extends RoleDTO> RoleDTO create(final S entity) {
        var newRole = mapper.newRole(entity);
        var savedNewRole = roleRepository.save(newRole);
        return mapper.roleDTO(savedNewRole);
    }

    @Override
    public <S extends RoleDTO> RoleDTO update(final Long id, final S entity) {
        return roleRepository.findById(id)
                             .map(role -> {
                                 role.setId(entity.id());
                                 role.setName(entity.name());
                                 return roleRepository.save(role);
                             })
                             .map(mapper::roleDTO)
                             .orElseThrow();
    }

    @Override
    public boolean delete(final Long id) {
        roleRepository.deleteById(id);
        return !roleRepository.existsById(id);
    }
}

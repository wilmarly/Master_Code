package com.example.mastercode.services;

import com.example.mastercode.dto.RoleDto;
import com.example.mastercode.entities.Roles;
import com.example.mastercode.repositories.RoleRepository;
import com.example.mastercode.services.Interface.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    //create role class object

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
/*    @Transactional*/
    public List<Roles> findAll() throws Exception {
        try {

            List<Roles> entities = roleRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
/*    @Transactional*/
    public Roles findById(Long id) throws Exception {
        try {
            Optional<Roles> entityOptional = roleRepository.findById(id);
            return entityOptional.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
/*    @Transactional*/
    public Roles create(Roles entity) throws Exception {

        try {
            entity = roleRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
/*    @Transactional*/
    public Roles update(Long id, Roles entity) throws Exception {
        try {
            Optional<Roles> roleOptional = roleRepository.findById(id);
            Roles rolesUpdate = roleOptional.get();
            rolesUpdate = roleRepository.save(entity);
            return rolesUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
/*    @Transactional*/
    public boolean delete(Long id) throws Exception {
        try {
            if (roleRepository.existsById(id)) {
                roleRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public RoleDto getRoleData(Long idRole) throws Exception {

        try {
            Optional<Roles> role = roleRepository.findById(idRole);

            RoleDto roleDto = new RoleDto();

            roleDto.setIdRole(role.get().getIdRole());
            roleDto.setRole(role.get().getRole());


            return roleDto;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}

package com.example.mastercode.services;

import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.repositories.EnterpriseRepository;
import com.example.mastercode.services.Interface.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public List<Enterprise> findAll() throws Exception {
        try {

            List<Enterprise> entities = enterpriseRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Enterprise findById(Long id) throws Exception {
        try {
            Optional<Enterprise> entityOptional = enterpriseRepository.findById(id);
            return entityOptional.get();

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Enterprise create(Enterprise entity) throws Exception {

        try {
            entity = enterpriseRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Enterprise update(Long id, Enterprise entity) throws Exception {
        try {
            Optional<Enterprise> enterpiseOptional = enterpriseRepository.findById(id);
            Enterprise enterpriseUpdate = enterpiseOptional.get();
            enterpriseUpdate = enterpriseRepository.save(entity);
            return enterpriseUpdate;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {

        try {
            if (enterpriseRepository.existsById(id)) {
                enterpriseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

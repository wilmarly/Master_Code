package com.example.mastercode.services;

import com.example.mastercode.dto.EnterpriseDTO;
import com.example.mastercode.repositories.EnterpriseRepository;
import com.example.mastercode.services.contracts.BaseService;
import com.example.mastercode.services.mapper.EntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnterpriseServiceImpl implements BaseService<EnterpriseDTO> {

    private final EnterpriseRepository enterpriseRepository;
    private final EntityMapper mapper;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.mapper = new EntityMapper();
    }


    @Override
    public List<EnterpriseDTO> findAll() {
        return enterpriseRepository.findAll()
                                   .stream()
                                   .map(mapper::enterpriseDTO)
                                   .toList();
    }

    @Override
    public EnterpriseDTO findById(Long idEnterprise) {
        return enterpriseRepository.findById(idEnterprise)
                                   .map(mapper::enterpriseDTO)
                                   .orElseThrow();
    }

    @Override
    public EnterpriseDTO create(final EnterpriseDTO entity) {
        var enterprise = mapper.newEnterprise(entity);
        var savedEnterprise = enterpriseRepository.save(enterprise);
        return mapper.enterpriseDTO(savedEnterprise);
    }

    @Override
    public <S extends EnterpriseDTO> EnterpriseDTO update(final Long id, final S entity) {
        var enterpriseFromDB = enterpriseRepository.findById(id);
        return enterpriseFromDB.map(enterprise -> {
                                   enterprise.setId(entity.getId());
                                   enterprise.setNit(entity.getNit());
                                   enterprise.setName(entity.getName());
                                   enterprise.setPhone(entity.getPhone());
                                   enterprise.setAddress(entity.getAddress());
                                   return enterpriseRepository.save(enterprise);
                               })
                               .map(mapper::enterpriseDTO)
                               .orElseThrow();
    }

    @Override
    public boolean delete(final Long id) {
        enterpriseRepository.deleteById(id);
        return enterpriseRepository.findById(id).isEmpty();
    }
}

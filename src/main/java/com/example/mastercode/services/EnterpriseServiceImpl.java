package com.example.mastercode.services;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.repositories.EnterpriseRepository;
import com.example.mastercode.services.Interface.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    private EnterpriseDto convertEntityDto(Enterprise enterprise) {

        Optional<Enterprise> enterprises = enterpriseRepository.findById(enterprise.getIdEnterprise());
        List<Long> idTransactions = new ArrayList<>();
        enterprises.get().getTransactionList().forEach((t) -> {
            idTransactions.add(t.getIdTransaction());
        });

        List<String> employeeNames = new ArrayList<>();
        enterprises.get().getEmployeesList().forEach((t) -> {
            employeeNames.add(t.getProfile().getName());
        });

        EnterpriseDto enterpriseDto = new EnterpriseDto();

        enterpriseDto.setIdEnterprise(enterprise.getIdEnterprise());
        enterpriseDto.setName(enterprise.getName());
        enterpriseDto.setNit(enterprise.getNit());
        enterpriseDto.setPhone(enterprise.getPhone());
        enterpriseDto.setTransactionList(idTransactions);
        enterpriseDto.setEmployeesList(employeeNames);
        enterpriseDto.setCreated_at(enterprise.getCreated_at());
        enterpriseDto.setUpdated_at(enterprise.getUpdated_at());

        return enterpriseDto;
    }

    @Override
    public List<EnterpriseDto> findAll() {
        return enterpriseRepository.findAll()
                .stream()
                .map(this::convertEntityDto)
                .collect(Collectors.toList());
    }

    @Override
    public EnterpriseDto findById(Long idEnterprise) {

        Optional<Enterprise> enterprises = enterpriseRepository.findById(idEnterprise);
        List<Long> idTransactions = new ArrayList<>();
        enterprises.get().getTransactionList().forEach((t) -> {
            idTransactions.add(t.getIdTransaction());
        });

        List<String> employeeNames = new ArrayList<>();
        enterprises.get().getEmployeesList().forEach((t) -> {
            employeeNames.add(t.getProfile().getName());
        });

        EnterpriseDto enterpriseDto = new EnterpriseDto();

        enterpriseDto.setIdEnterprise(enterprises.get().getIdEnterprise());
        enterpriseDto.setName(enterprises.get().getName());
        enterpriseDto.setNit(enterprises.get().getNit());
        enterpriseDto.setPhone(enterprises.get().getPhone());
        enterpriseDto.setTransactionList(idTransactions);
        enterpriseDto.setEmployeesList(employeeNames);
        enterpriseDto.setCreated_at(enterprises.get().getCreated_at());
        enterpriseDto.setUpdated_at(enterprises.get().getUpdated_at());

        return enterpriseDto;
    }

    @Override
    public Enterprise create(Enterprise entity) {

        return enterpriseRepository.save(entity);
    }

    @Override
    public Enterprise update(Long id, Enterprise entity) {

        Optional<Enterprise> enterpriseUpdate = enterpriseRepository.findById(id);

        Enterprise enterprise = enterpriseUpdate.get();

        if (entity.getName() != null) {
            enterprise.setName(entity.getName());
        }
        if (entity.getNit() != null) {
            enterprise.setNit(entity.getNit());
        }
        if (entity.getPhone() != null) {
            enterprise.setPhone(entity.getPhone());
        }
        if (entity.getAddress() != null) {
            enterprise.setAddress(entity.getAddress());
        }
        if (entity.getCreated_at() != null) {
            enterprise.setCreated_at(entity.getCreated_at());
        }
        if (entity.getUpdated_at() != null) {
            enterprise.setUpdated_at(entity.getUpdated_at());
        }
           Enterprise responde = enterpriseRepository.save(enterprise);

        return responde;
    }

    @Override
    public boolean delete(Long id) {
        enterpriseRepository.deleteById(id);
        return true;


    }
}

package com.example.mastercode.services;

import com.example.mastercode.dto.EnterpriseDto;
import com.example.mastercode.dto.TransactionByEnterpriseResponse;
import com.example.mastercode.dto.TransactionShortDto;
import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;
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

    private EnterpriseDto convertEntityDto(Enterprise enterprises) {


        List<Long> idTransactions = new ArrayList<>();

        enterprises.getEmployeesList().forEach(employee -> {
            employee.getTransaction().forEach(transaction -> {
                idTransactions.add(transaction.getIdTransaction());
            });
        });

        List<String> employeeNames = new ArrayList<>();
        enterprises.getEmployeesList().forEach((t) -> {
            employeeNames.add(t.getProfile().getName());
        });

        EnterpriseDto enterpriseDto = new EnterpriseDto();

        enterpriseDto.setIdEnterprise(enterprises.getIdEnterprise());
        enterpriseDto.setName(enterprises.getName());
        enterpriseDto.setNit(enterprises.getNit());
        enterpriseDto.setPhone(enterprises.getPhone());
        enterpriseDto.setAddress(enterprises.getAddress());
        enterpriseDto.setTransactionList(idTransactions);
        enterpriseDto.setEmployeesList(employeeNames);
        enterpriseDto.setCreated_at(enterprises.getCreated_at());
        enterpriseDto.setUpdated_at(enterprises.getUpdated_at());

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

        return convertEntityDto(enterpriseRepository.findById(idEnterprise).get());

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
        Enterprise response = enterpriseRepository.save(enterprise);

        return response;
    }

    @Override
    public boolean delete(Long id) {
        enterpriseRepository.deleteById(id);
        return true;
    }

    @Override
    public TransactionByEnterpriseResponse transactionByEnterprise(Long idEnterprises) {

        Enterprise enterprise = enterpriseRepository.findById(idEnterprises).get();

        List<TransactionShortDto> transactionShortDtoList = new ArrayList<>();

        enterprise.getEmployeesList().forEach(employee -> {
            employee.getTransaction().forEach(transaction -> {
                TransactionShortDto transactionShortDto = new TransactionShortDto();
                transactionShortDto.setIdTransaction(transaction.getIdTransaction());
                transactionShortDto.setConcept(transaction.getConcept());
                transactionShortDto.setAmount(transaction.getAmount());
                transactionShortDto.setName(employee.getProfile().getName());

                transactionShortDtoList.add(transactionShortDto);
            });
        });

        TransactionByEnterpriseResponse transactionByEnterpriseResponse = new TransactionByEnterpriseResponse();

        transactionByEnterpriseResponse.setIdEnterprise(enterprise.getIdEnterprise());
        transactionByEnterpriseResponse.setNameEnterprise(enterprise.getName());
        transactionByEnterpriseResponse.setTransactionList(transactionShortDtoList);

        return transactionByEnterpriseResponse;
    }
}

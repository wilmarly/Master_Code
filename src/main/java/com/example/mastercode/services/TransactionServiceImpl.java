package com.example.mastercode.services;

import com.example.mastercode.dto.TransactionDTO;
import com.example.mastercode.entities.Employee;
import com.example.mastercode.repositories.EmployeeRepository;
import com.example.mastercode.repositories.TransactionRepository;
import com.example.mastercode.services.contracts.TransactionBusiness;
import com.example.mastercode.services.mapper.EntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionBusiness {

    private final TransactionRepository transactionRepository;
    private final EntityMapper mapper;
    private final EmployeeRepository employeeRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, EmployeeRepository employeeRepository) {
        this.transactionRepository = transactionRepository;
        this.mapper = new EntityMapper();
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<TransactionDTO> findAll() {
        return transactionRepository.findAll()
                                    .stream()
                                    .map(mapper::transactionDTO)
                                    .toList();
    }

    @Override
    public TransactionDTO findById(Long id) {
        return transactionRepository.findById(id)
                                    .map(mapper::transactionDTO)
                                    .orElseThrow();
    }

    @Override
    public <S extends TransactionDTO> TransactionDTO create(final S entity) {
        var newTransaction = mapper.newTransaction(entity);
        Optional<Employee> employeeFromDB = employeeRepository.findByProfileName(entity.employee());
        return employeeFromDB.map(employee -> {
                                 newTransaction.setEmployee(employee);
                                 return transactionRepository.save(newTransaction);
                             })
                             .map(mapper::transactionDTO)
                             .orElseThrow();

    }

    @Override
    public <S extends TransactionDTO> TransactionDTO update(final Long id, final S entity) {
        return transactionRepository.findById(id)
                                    .map(transaction -> {
                                        transaction.setId(entity.id());
                                        transaction.setAmount(entity.amount());
                                        transaction.setConcept(entity.concept());
                                        return transactionRepository.save(transaction);
                                    })
                                    .map(mapper::transactionDTO)
                                    .orElseThrow();
    }


    @Override
    public boolean delete(final Long id) {
        transactionRepository.deleteById(id);
        return transactionRepository.existsById(id);
    }

    @Override
    public List<TransactionDTO> findAllByEnterprise(final String nit) {
        return transactionRepository.allTransactionsByEnterprise(nit).stream().map(mapper::transactionDTO).toList();
    }
}



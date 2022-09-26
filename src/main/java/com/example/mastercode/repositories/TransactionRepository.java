package com.example.mastercode.repositories;

import com.example.mastercode.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByEmployeeIdEmployee(Long idEmployee);

    @Query(value = """
                    select t from Transaction t
                    left join fetch t.employee e
                    left join fetch e.enterprise ent
                    where ent.idEnterprise = :idEnterprise
                   """)
    List<Transaction> allTransactionsByEnterprise(Long idEnterprise);


}

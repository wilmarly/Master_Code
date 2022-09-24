package com.example.mastercode.repositories;

import com.example.mastercode.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = """
                    select t from Transaction t
                    left join fetch t.employee e
                    left join fetch e.enterprise ent
                    where ent.nit = :nit
                   """)
    List<Transaction> allTransactionsByEnterprise(@Param("nit") String nit);

}

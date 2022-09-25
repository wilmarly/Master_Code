package com.example.mastercode.repositories;

import com.example.mastercode.entities.Enterprise;
import com.example.mastercode.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
    @Query(value = """
                    select t from Transaction t
                    left join fetch t.employee e
                    left join fetch e.enterprise ent
                    where ent.nit = :nit
                   """)
    List<Transaction> allTransactionsByEnterprise(@Param("nit") String nit);


}

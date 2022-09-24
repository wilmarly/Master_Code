package com.example.mastercode.entities;

import com.example.mastercode.entities.common.AuditableEntity;
import com.example.mastercode.entities.common.IdentificableEntity;
import com.example.mastercode.entities.embedded.Auditable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "transactions", schema = "crudexample")
public class Transaction implements Serializable, IdentificableEntity, AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // transaction id
    @Column(name = "amount")
    private BigDecimal amount; // transaction amount
    @Column(name = "concept")
    private String concept;// transaction concept
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @Embedded
    private Auditable auditable;

    public Transaction() {
        //default contructor
    }

    public Auditable getAuditable() {
        return auditable;
    }

    public void setAuditable(final Auditable auditable) {
        this.auditable = auditable;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Transaction that = (Transaction) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long idTransaction) {
        this.id = idTransaction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

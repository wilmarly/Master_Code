package com.example.mastercode.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Transactions")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction; // transaction id
    @Column(name = "amount")
    private double amount; // transaction amount
    @Column(name = "concept")
    private String concept;// transaction concept
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
    @Column(name = "created_at")
    private LocalDate created_at;  // transaction created date
    @Column(name = "updated_at")
    private LocalDate updated_at;  // transaction updated date

    //Constructor
    public Transaction(double amount, String concept,  Employee employee, LocalDate created_at, LocalDate updated_at) {
        this.amount = amount;
        this.concept = concept;
        this.employee = employee;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Transaction() {//Void contructor
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + idTransaction +
                ", amount=" + amount +
                ", concept='" + concept + '\'' +
                ", employer=" + employee +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}

package com.example.payrollmanagmentsystem.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MedicalAllowance implements Serializable {
    @Id
    @GeneratedValue
    private int Id;
    private double amount;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "Id")
    private Employee employee;

    public MedicalAllowance(int id, double amount) {
        Id = id;
        this.amount = amount;
    }

    public MedicalAllowance() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MedicalAllowance{" +
                "amount=" + amount +
                '}';
    }
}

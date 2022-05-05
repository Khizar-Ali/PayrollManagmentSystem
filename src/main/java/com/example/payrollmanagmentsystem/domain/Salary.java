package com.example.payrollmanagmentsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Salary implements Serializable {
    @Id
    @GeneratedValue
    private int Id;
    private Date createdDate;

    @ManyToOne
    private Employee employee;

    public Salary(int id, Date createdDate, Employee employee) {
        Id = id;
        this.createdDate = createdDate;
        this.employee = employee;
    }

    public Salary() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "createdDate=" + createdDate +
                '}';
    }
}


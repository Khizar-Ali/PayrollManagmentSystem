package com.example.payrollmanagmentsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Leave implements Serializable {
    @Id
    @GeneratedValue
    private int Id;
    private int noOfLeaves;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Employee employee;

    public Leave(int id, int noOfLeaves, Date startDate, Date endDate, Employee employee) {
        Id = id;
        this.noOfLeaves = noOfLeaves;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Leave() {
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

    public int getNoOfLeaves() {
        return noOfLeaves;
    }

    public void setNoOfLeaves(int noOfLeaves) {
        this.noOfLeaves = noOfLeaves;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Leave{" +
                "Id=" + Id +
                ", noOfLeaves=" + noOfLeaves +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

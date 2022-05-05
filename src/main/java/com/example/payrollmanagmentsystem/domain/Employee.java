package com.example.payrollmanagmentsystem.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue
    private Integer Id;

    @Column(name = "empName",nullable = false)
    private String empName;

    private Date joinDate;
    private double salary;

    @ManyToOne
    private Department department;


    public Employee(Integer id, String empName, Date joinDate, double salary, Department department) {
        Id = id;
        this.empName = empName;
        this.joinDate = joinDate;
        this.salary = salary;
        this.department = department;
    }


    public Employee() {
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", empName='" + empName + '\'' +
                ", joinDate=" + joinDate +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}

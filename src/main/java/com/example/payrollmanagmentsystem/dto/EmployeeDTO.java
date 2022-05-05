package com.example.payrollmanagmentsystem.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer id;
    private String empName;
    private double salary;
    private String deptName;
}

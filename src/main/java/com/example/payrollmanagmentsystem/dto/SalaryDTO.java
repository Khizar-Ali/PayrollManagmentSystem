package com.example.payrollmanagmentsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SalaryDTO {
    private int id;
    private String empName;
    private Date createdDate;
}

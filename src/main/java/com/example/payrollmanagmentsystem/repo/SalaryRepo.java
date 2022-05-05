package com.example.payrollmanagmentsystem.repo;

import com.example.payrollmanagmentsystem.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
}

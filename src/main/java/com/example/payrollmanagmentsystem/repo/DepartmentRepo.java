package com.example.payrollmanagmentsystem.repo;

import com.example.payrollmanagmentsystem.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
}

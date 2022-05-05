package com.example.payrollmanagmentsystem.repo;

import com.example.payrollmanagmentsystem.domain.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepo extends JpaRepository<Leave, Integer> {
}

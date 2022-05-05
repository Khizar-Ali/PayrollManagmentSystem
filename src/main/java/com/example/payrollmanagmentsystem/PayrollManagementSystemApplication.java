package com.example.payrollmanagmentsystem;

import com.example.payrollmanagmentsystem.domain.Department;
import com.example.payrollmanagmentsystem.domain.Employee;
import com.example.payrollmanagmentsystem.repo.DepartmentRepo;
import com.example.payrollmanagmentsystem.repo.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PayrollManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayrollManagementSystemApplication.class, args);
    }


/*    @Bean
    CommandLineRunner commandLineRunner1(DepartmentRepo departmentRepo){
        return args -> {
            departmentRepo.save(new Department("Sales"));
            departmentRepo.save(new Department("IT"));
            departmentRepo.save(new Department("Finance"));
        };
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo){
        return args -> {
            employeeRepo.save(new Employee(1,"Khizar",new Date(2021,12,23),5000,
                    departmentRepo.findById("Sales").get()));
        };
    }*/
}

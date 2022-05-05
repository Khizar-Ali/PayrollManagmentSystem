package com.example.payrollmanagmentsystem.web;

import com.example.payrollmanagmentsystem.domain.Employee;
import com.example.payrollmanagmentsystem.domain.Salary;
import com.example.payrollmanagmentsystem.dto.SalaryDTO;
import com.example.payrollmanagmentsystem.exception.UserNotFoundException;
import com.example.payrollmanagmentsystem.repo.EmployeeRepo;
import com.example.payrollmanagmentsystem.repo.SalaryRepo;
import com.example.payrollmanagmentsystem.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SalaryResponse {
    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    private SalaryService salaryService;

    @GetMapping("/salary")
    public List<Salary> retrieveAllUsers(){
        return salaryRepo.findAll();
    }

    @GetMapping("/salary/{id}")
    public Optional<Salary> retrieveUser(@PathVariable int id){
        Optional<Salary> user = salaryRepo.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        return user;
    }

    @GetMapping("/salary/employee")
    public List<SalaryDTO> retrieveAllSalary(int id){
        List<SalaryDTO> salaryDTOS = salaryService.getAllSalary(id);

        return salaryDTOS;
    }

    @PostMapping("/salary")
    public ResponseEntity<Object> createUser(@Validated @RequestBody Salary salary){
        Salary savedUser = salaryRepo.save(salary);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/salary/{id}")
    public void deleteUser(@PathVariable int id){
        salaryRepo.deleteById(id);

   /* if(user==null)
         throw new UserNotFoundException("id-"+ id);*/
    }

}

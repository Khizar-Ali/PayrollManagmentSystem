package com.example.payrollmanagmentsystem.web;


import com.example.payrollmanagmentsystem.domain.Employee;
import com.example.payrollmanagmentsystem.dto.EmployeeDTO;
import com.example.payrollmanagmentsystem.exception.UserNotFoundException;
import com.example.payrollmanagmentsystem.repo.EmployeeRepo;
import com.example.payrollmanagmentsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeResponse {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/employee")
    public List<Employee> retrieveAllUsers(){
        return employeeRepo.findAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> retrieveUser(@PathVariable int id){
        Optional<Employee> user = employeeRepo.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        return user;
    }
    @GetMapping("/employee/department")
    public List<EmployeeDTO> retrieveAllEmployee(@RequestParam String deptName){
        List<EmployeeDTO> employeeDTOS = employeeService.getAllEmployeeDepartment(deptName);

        return employeeDTOS;
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createUser(@Validated @RequestBody Employee employee){
        Employee savedUser = employeeRepo.save(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/employee/{id}")
    public void deleteUser(@PathVariable int id){
        employeeRepo.deleteById(id);

   /* if(user==null)
         throw new UserNotFoundException("id-"+ id);*/
    }

}

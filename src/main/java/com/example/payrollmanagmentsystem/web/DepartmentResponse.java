package com.example.payrollmanagmentsystem.web;

import com.example.payrollmanagmentsystem.domain.Department;
import com.example.payrollmanagmentsystem.dto.EmployeeDTO;
import com.example.payrollmanagmentsystem.exception.UserNotFoundException;
import com.example.payrollmanagmentsystem.repo.DepartmentRepo;
import com.example.payrollmanagmentsystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResponse {
    @Autowired
    private DepartmentRepo departmentRepo;



    @GetMapping("/departments")
    public List<Department> retrieveAllDepartments(){
        return departmentRepo.findAll();
    }



    @GetMapping("/department")
    public Optional<Department> retrieveUser(@RequestParam String id){
        Optional<Department> user = departmentRepo.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        return user;
    }

    @PostMapping("/department")
    public ResponseEntity<Object> createUser(@RequestBody Department department){
        Department savedUser = departmentRepo.save(department);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{deptName}")
                .buildAndExpand(savedUser.getDeptName())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/department/{dept}")
    public void deleteUser(@RequestParam String dept){
        departmentRepo.deleteById(dept);

   /* if(user==null)
         throw new UserNotFoundException("id-"+ id);*/
    }

}

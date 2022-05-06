package com.example.payrollmanagmentsystem.web;

import com.example.payrollmanagmentsystem.domain.MedicalAllowance;
import com.example.payrollmanagmentsystem.dto.LeaveDTO;
import com.example.payrollmanagmentsystem.dto.MedicalAllowanceDTO;
import com.example.payrollmanagmentsystem.exception.UserNotFoundException;
import com.example.payrollmanagmentsystem.repo.MedicalAllowanceRepo;
import com.example.payrollmanagmentsystem.services.MedicalAllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class MedicalAllowanceResponse {
    @Autowired
    private MedicalAllowanceRepo medicalAllowanceRepo;

    @Autowired
    private MedicalAllowanceService medicalAllowanceService;

    @GetMapping("/medicalallowance")
    public List<MedicalAllowance> retrieveAllUsers(){
        return medicalAllowanceRepo.findAll();
    }

    @GetMapping("/medicalallowance/{id}")
    public Optional<MedicalAllowance> retrieveUser(@PathVariable int id){
        Optional<MedicalAllowance> user = medicalAllowanceRepo.findById(id);

        if(!user.isPresent())
            throw new UserNotFoundException("id-"+ id);

        return user;
    }

    @GetMapping("/medicalallowance/employee")
    public List<MedicalAllowanceDTO> retrieveAllowance(@RequestBody int id){
        List<MedicalAllowanceDTO> medicalAllowanceDTOS = medicalAllowanceService.getMedicalAllowance(id);
        return medicalAllowanceDTOS;
    }

    @PostMapping("/medicalallowance")
    public ResponseEntity<Object> createUser(@Validated @RequestBody MedicalAllowance medicalAllowance){
        MedicalAllowance savedUser = medicalAllowanceRepo.save(medicalAllowance);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/medicalallowance/{id}")
    public void deleteUser(@PathVariable int id){
        medicalAllowanceRepo.deleteById(id);

   /* if(user==null)
         throw new UserNotFoundException("id-"+ id);*/
    }

}
